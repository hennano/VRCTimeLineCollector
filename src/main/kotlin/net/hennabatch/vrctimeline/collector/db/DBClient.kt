package net.hennabatch.vrctimeline.collector.db

import net.hennabatch.vrctimeline.collector.db.entity.DBEntity
import net.hennabatch.vrctimeline.collector.db.entity.DataExtractEntity
import net.hennabatch.vrctimeline.collector.db.entity.EnumIdTable
import net.hennabatch.vrctimeline.collector.db.entity.WorldEntity
import org.komapper.jdbc.JdbcDatabase
import kotlin.reflect.*

object DBClient {

    private lateinit var jdbcDatabase: JdbcDatabase

    fun initialize(url: String, user: String, password: String){
        jdbcDatabase = JdbcDatabase.create(
            url = url,
            user = user,
            password = password
        )
    }

    fun client():JdbcDatabase{
        return jdbcDatabase
    }

    fun insertEvent(entities: List<DBEntity>){

    }








    fun bindId(entity: DBEntity):DBEntity {
        //バインド対象の検索
        //ToDoどのカラムになんのidを入れるかをリンク付
        val keys = getKeysMap(entity) ?: return entity
        val targetKeys = keys.mapNotNull { member ->
                EnumIdTable.values().filter{ it.entityClass != entity::class}
                    .find { it.idName == member.value }
            }.toMutableList()
        getBindIdType(entity)?.let { targetKeys.add(it) }




    }

    private fun getKeysMap(entity: DBEntity):Map<KProperty1<DBEntity, Any?>, String>? {
        val kProperty = entity::class.members.find { it.name == "keyMap" } as KProperty1<DBEntity, Map<KProperty1<DBEntity, Any?>, String>>
        return kProperty.get(entity)

    }

    private fun getBindIdType(entity: DBEntity):EnumIdTable?{
        if(entity::class == DataExtractEntity::class) return  null
        val keys = getKeysMap(entity)
        if(keys?.map { it.value }?.contains("bind_id_type") != true) return null
        val kProperty = entity::class.members.find { it.name == "bind_id_type" } as KProperty1<DBEntity, String>
        val idType = kProperty.get(entity)
        return  EnumIdTable.values().find { it.idName == idType }
    }
}