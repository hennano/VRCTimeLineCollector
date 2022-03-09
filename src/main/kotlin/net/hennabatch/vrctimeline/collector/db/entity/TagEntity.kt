package net.hennabatch.vrctimeline.collector.db.entity

import org.komapper.annotation.*
import kotlin.reflect.KClass
import kotlin.reflect.KProperty1

@KomapperEntity
data class TagEntity(
    @KomapperId
    @KomapperAutoIncrement
    @KomapperColumn(name = "tag_id")
    val id: Int = -1,

    @KomapperColumn(name = "tag_type_id")
    val tagTypeId: Int = -1,

    //どのidを保存するかkeyを指定する
    @KomapperColumn(name = "bind_id_type")
    val bindIdType: String,

    //idを保存する
    @KomapperColumn(name = "bind_id")
    val contentRoleId: Int,

    @KomapperIgnore
    val keyMap: Map<KProperty1<TagEntity, Any?>, String> = mapOf(
        Pair(TagEntity::id, "picture_id"),
        Pair(TagEntity::tagTypeId, "tag_type_id"),
        Pair(TagEntity::bindIdType, "bind_id_type"),
        Pair(TagEntity::contentRoleId, "bind_id")
    )
): DBEntity
