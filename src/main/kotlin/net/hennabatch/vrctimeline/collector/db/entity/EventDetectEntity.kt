package net.hennabatch.vrctimeline.collector.db.entity

import org.komapper.annotation.*
import java.time.LocalDateTime
import kotlin.reflect.KProperty1

@KomapperEntity
data class EventDetectEntity(

    @KomapperId
    @KomapperAutoIncrement
    @KomapperColumn(name = "event_detect_id")
    val id: Int = -1,

    @KomapperColumn(name = "event_type_id")
    val eventTypeId: Int = -1,

    @KomapperColumn(name = "detect_regex")
    val detectRegex: String = "",

    @KomapperCreatedAt
    @KomapperColumn(name = "created_at")
    val createdAt: LocalDateTime? = null,

    @KomapperUpdatedAt
    @KomapperColumn(name = "updated_at")
    val updatedAt: LocalDateTime?= null,


    //逆参照用
    @KomapperIgnore
    val keyMap: Map<KProperty1<EventDetectEntity, Any?>, String> = mapOf(
        Pair(EventDetectEntity::id, "event_detect_id"),
        Pair(EventDetectEntity::eventTypeId, "event_type_id"),
        Pair(EventDetectEntity::detectRegex, "detect_regex"),
        Pair(EventDetectEntity::createdAt, "created_at"),
        Pair(EventDetectEntity::updatedAt, "updated_at")
    )
): DBEntity