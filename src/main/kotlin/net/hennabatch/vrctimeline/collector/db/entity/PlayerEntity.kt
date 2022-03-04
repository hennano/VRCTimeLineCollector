package net.hennabatch.vrctimeline.collector.db.entity

import org.komapper.annotation.*
import java.time.LocalDateTime

@KomapperEntity
data class PlayerEntity(
    @KomapperId
    @KomapperAutoIncrement
    @KomapperColumn(name = "player_id")
    val id: Int,

    @KomapperColumn(name = "vrc_player_id")
    val vrcPlayerId: String = "",

    @KomapperColumn(name = "name")
    val name: String,

    @KomapperColumn(name = "is_friend")
    val isFriend: Boolean = false,

    @KomapperCreatedAt
    @KomapperColumn(name = "created_at")
    val createdAt: LocalDateTime? = null,

    @KomapperUpdatedAt
    @KomapperColumn(name = "updated_at")
    val updatedAt: LocalDateTime?= null
)
