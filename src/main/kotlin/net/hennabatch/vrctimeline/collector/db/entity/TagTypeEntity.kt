package net.hennabatch.vrctimeline.collector.db.entity

import org.komapper.annotation.*
import java.time.LocalDateTime
import kotlin.reflect.KProperty1

@KomapperEntity
data class TagTypeEntity(
    @KomapperId
    @KomapperAutoIncrement
    @KomapperColumn(name = "tag_type_id")
    val id: Int = -1,

    //player名
    @KomapperColumn(name = "name")
    var name: String,

    @KomapperColumn(name = "description")
    var description: String,

    @KomapperIgnore
    val keyMap: Map<KProperty1<TagTypeEntity, Any?>, String> = mapOf(
        Pair(TagTypeEntity::id, "picture_id"),
        Pair(TagTypeEntity::name, "name"),
        Pair(TagTypeEntity::description, "description"),
    )
):DBEntity