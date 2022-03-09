package net.hennabatch.vrctimeline.collector.db.entity

import org.komapper.annotation.*
import java.time.LocalDateTime
import kotlin.reflect.KProperty1

@KomapperEntity
data class PlayerEntity(
    @KomapperId
    @KomapperAutoIncrement
    @KomapperColumn(name = "player_id")
    val id: Int = -1,

    //vrc側のplayerid
    @KomapperColumn(name = "vrc_player_id")
    val vrcPlayerId: String = "",

    //player名
    @KomapperColumn(name = "name")
    var name: String,

    @KomapperCreatedAt
    @KomapperColumn(name = "created_at")
    val createdAt: LocalDateTime? = null,

    @KomapperUpdatedAt
    @KomapperColumn(name = "updated_at")
    val updatedAt: LocalDateTime?= null,

    @KomapperIgnore
    val keyMap: Map<KProperty1<PlayerEntity, Any?>, String> = mapOf(
        Pair(PlayerEntity::id, "picture_id"),
        Pair(PlayerEntity::vrcPlayerId, "vrc_player_id"),
        Pair(PlayerEntity::name, "String"),
        Pair(PlayerEntity::createdAt, "created_at"),
        Pair(PlayerEntity::updatedAt, "updated_at"),
    )
): DBEntity
