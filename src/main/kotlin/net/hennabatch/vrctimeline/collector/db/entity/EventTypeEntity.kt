package net.hennabatch.vrctimeline.collector.db.entity

import org.komapper.annotation.*
import kotlin.reflect.KProperty1

@KomapperEntity
data class EventTypeEntity(
    @KomapperId
    @KomapperAutoIncrement
    @KomapperColumn(name = "event_type_id")
    val id: Int = -1,

    @KomapperColumn(name = "name")
    var name: String,

    @KomapperColumn(name = "description")
    var description: String,

    @KomapperColumn(name = "enable_overwrite")
    val enableOverwrite: Boolean = false,

    //逆参照用
    @KomapperIgnore
    val keyMap: Map<KProperty1<EventTypeEntity, Any?>, String> = mapOf(
        Pair(EventTypeEntity::id, "event_type_id"),
        Pair(EventTypeEntity::name, "name"),
        Pair(EventTypeEntity::description, "description"),
        Pair(EventTypeEntity::enableOverwrite, "enable_overwrite")
    )
): DBEntity
