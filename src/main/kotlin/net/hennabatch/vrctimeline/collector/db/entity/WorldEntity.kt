package net.hennabatch.vrctimeline.collector.db.entity

import org.komapper.annotation.*
import java.time.LocalDateTime

@KomapperEntity
data class WorldEntity(
    @KomapperId
    @KomapperAutoIncrement
    @KomapperColumn(name = "world_id")
    val id: Int,

    @KomapperColumn(name = "vrc_world_id")
    val vrcWorldId: String,

    @KomapperColumn(name = "name")
    val name: String,

    @KomapperCreatedAt
    @KomapperColumn(name = "created_at")
    val createdAt: LocalDateTime? = null,
)
