package net.hennabatch.vrctimeline.collector.db.entity

import org.komapper.annotation.*
import java.time.LocalDateTime
import java.util.Objects
import kotlin.reflect.KParameter
import kotlin.reflect.KProperty
import kotlin.reflect.KProperty1

@KomapperEntity
data class WorldEntity(
    @KomapperId
    @KomapperAutoIncrement
    @KomapperColumn(name = "world_id")
    val id: Int = -1,

    //vrc側のworldid
    @KomapperColumn(name = "vrc_world_id")
    var vrcWorldId: String,

    //world名
    @KomapperColumn(name = "name")
    var name: String,

    @KomapperCreatedAt
    @KomapperColumn(name = "created_at")
    val createdAt: LocalDateTime? = null,

    @KomapperIgnore
    val keyMap: Map<KProperty1<WorldEntity, Any?>, String> = mapOf(
        Pair(WorldEntity::id, "picture_id"),
        Pair(WorldEntity::vrcWorldId, "vrc_world_id"),
        Pair(WorldEntity::name, "name"),
        Pair(WorldEntity::createdAt, "created_at"),
    )

): DBEntity
