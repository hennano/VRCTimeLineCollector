package net.hennabatch.vrctimeline.collector.db.entity

import org.komapper.annotation.*
import java.time.LocalDateTime
import kotlin.reflect.KClass
import kotlin.reflect.KProperty1

@KomapperEntity
data class ContentEntity(
    @KomapperId
    @KomapperAutoIncrement
    @KomapperColumn(name = "content_id")
    val id: Int = -1,

    @KomapperColumn(name = "trigger_id")
    val triggerId: Int = -1,

    //bindidに保持するデータの種類を確定するために使用
    //ContentBindEntity側で指定する
    @KomapperColumn(name = "bind_id_type")
    val bindIdType: String = "",

    //何らかのidを保存する
    //ContentBindEntity側で指定する
    @KomapperColumn(name = "bind_id")
    val bindId: Int = -1,

    @KomapperCreatedAt
    @KomapperColumn(name = "created_at")
    val createdAt: LocalDateTime? = null,

    //逆参照用
    @KomapperIgnore
    val keyMap: Map<KProperty1<ContentEntity, Any?>, String> = mapOf(
        Pair(ContentEntity::id, "content_id"),
        Pair(ContentEntity::triggerId, "trigger_id"),
        Pair(ContentEntity::bindIdType, "bind_id_type"),
        Pair(ContentEntity::bindId, "bind_id"),
        Pair(ContentEntity::createdAt, "created_at"),
    )
): DBEntity
