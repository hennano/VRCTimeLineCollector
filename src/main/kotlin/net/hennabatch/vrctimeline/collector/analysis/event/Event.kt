package net.hennabatch.vrctimeline.collector.analysis.event

import net.hennabatch.vrctimeline.collector.analysis.LogData
import net.hennabatch.vrctimeline.collector.db.DBCache
import net.hennabatch.vrctimeline.collector.db.entity.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.reflect.KClass
import kotlin.reflect.KMutableProperty
import kotlin.reflect.full.*
import kotlin.reflect.jvm.isAccessible

class Event(private val logData: LogData,
            private val eventDetectEntity: EventDetectEntity){

    //DBにアクセスせずにすべてのEntityを返す
    fun extractAllEntities(): List<DBEntity>{
        val entities = mutableListOf<DBEntity>()
        val dataExtractors = DBCache.dataExtractor.filter { it.eventDetectorId == eventDetectEntity.id }
                                                    .map { it.copy() }
        val dataEntitiesNullAble = dataExtractors.map { getExtractedEntity(it) }
        if(dataEntitiesNullAble.contains(null)) return entities
        val dataEntities = dataEntitiesNullAble.mapNotNull { it }
        val triggerEntity = TriggerEntity(
            id = -1,
            triggeredAt = logData.dateTime
        )
        val contentEntities = dataExtractors.map { ContentEntity(
            id = -1,
            triggerId = -1,
            bindIdType = it.bindIdType,
            bindId = -1,
            createdAt = null
        ) }
        entities.addAll(dataExtractors)
        entities.addAll(dataEntities)
        entities.add(triggerEntity)
        entities.addAll(contentEntities)

        return entities
    }

    //DBにアクセスせずにユーザー定義以外のEntityを返す
    fun extractEntities(): List<DBEntity>{
        return extractAllEntities().filter { it::class != EventTypeEntity::class &&
                                                    it::class != EventDetectEntity::class &&
                                                    it::class != DataExtractEntity::class &&
                                                    it::class != TagTypeEntity::class}
    }

    //DataExtracteEntityから代入先のEntityを代入した状態で生成
    private fun getExtractedEntity(dataExtractEntity: DataExtractEntity):DBEntity?{
        val targetclass = EnumIdTable.values().find { it.idName == dataExtractEntity.bindIdType }?.entityClass?: return null
        val targetEntity = targetclass.createInstance()
        val property = targetclass.memberProperties.find { it.name == dataExtractEntity.bindColumnType } as KMutableProperty< * >
        val strData = extractData(logData, dataExtractEntity)?: return null
        val data = when(property.returnType.classifier as KClass< * >){
            Int::class -> {
                strData.toInt()
            }
            String::class ->{
                strData
            }
            Boolean::class ->{
                strData.toBoolean()
            }
            LocalDateTime::class ->{
                toLocalDateTime(strData, "yyyy.MM.dd hh:mm:ss")
            }
            else -> null
        }?: return null
        property.isAccessible = true
        property.setter.call(targetEntity, data)
        return targetEntity
    }

    private fun extractData(logData: LogData, dataExtractEntity: DataExtractEntity): String? {
        return dataExtractEntity.extractRegex.toRegex().find(logData.message)?.value
    }

    private fun toLocalDateTime(date: String, format: String):LocalDateTime?{
        val formatter = DateTimeFormatter.ofPattern(format)
        return LocalDateTime.parse(date, formatter)
    }

}
