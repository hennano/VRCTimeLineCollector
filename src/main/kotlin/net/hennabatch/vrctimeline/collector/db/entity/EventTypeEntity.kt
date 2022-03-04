package net.hennabatch.vrctimeline.collector.db.entity

import org.komapper.annotation.KomapperAutoIncrement
import org.komapper.annotation.KomapperColumn
import org.komapper.annotation.KomapperEntity
import org.komapper.annotation.KomapperId

@KomapperEntity
data class EventTypeEntity(
    @KomapperId
    @KomapperAutoIncrement
    @KomapperColumn(name = "event_type_id")
    val id: Int,

    @KomapperColumn(name = "name")
    val name: String,

    @KomapperColumn(name = "description")
    val description: String,
)
