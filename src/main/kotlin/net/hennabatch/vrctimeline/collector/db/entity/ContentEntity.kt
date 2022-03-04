package net.hennabatch.vrctimeline.collector.db.entity

import org.komapper.annotation.*
import java.time.LocalDateTime

@KomapperEntity
data class ContentEntity(
    @KomapperId
    @KomapperAutoIncrement
    @KomapperColumn(name = "content_id")
    val id: Int,

    @KomapperColumn(name = "event_id")
    val eventId: Int,

    @KomapperColumn(name = "content_role_id")
    val contentRoleId: Int,

    @KomapperColumn(name = "bind_id")
    val bindId: Int,

    @KomapperCreatedAt
    @KomapperColumn(name = "created_at")
    val createdAt: LocalDateTime? = null,
)
