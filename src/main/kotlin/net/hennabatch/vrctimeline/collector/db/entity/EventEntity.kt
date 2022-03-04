package net.hennabatch.vrctimeline.collector.db.entity

import org.komapper.annotation.*
import java.time.LocalDateTime

@KomapperEntity
data class EventEntity(
    @KomapperId
    @KomapperAutoIncrement
    @KomapperColumn(name = "event_id")
    val id: Int,

    @KomapperColumn(name = "event_type_id")
    val eventTypeId: Int,

    @KomapperCreatedAt
    @KomapperColumn(name = "created_at")
    val createdAt: LocalDateTime? = null,
)
