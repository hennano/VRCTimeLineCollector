package net.hennabatch.vrctimeline.collector.db.entity

import org.komapper.annotation.*
import java.time.LocalDateTime
import kotlin.reflect.KProperty1

@KomapperEntity
data class PictureEntity(
    @KomapperId
    @KomapperAutoIncrement
    @KomapperColumn(name = "picture_id")
    val id: Int = -1,

    //ファイル名
    @KomapperColumn(name = "file_name")
    var fileName: String,

    //ファイルパス
    @KomapperColumn(name = "path")
    var path: String,

    @KomapperCreatedAt
    @KomapperColumn(name = "created_at")
    val createdAt: LocalDateTime? = null,

    //逆参照用
    @KomapperIgnore
    val keyMap: Map<KProperty1<PictureEntity, Any?>, String> = mapOf(
        Pair(PictureEntity::id, "picture_id"),
        Pair(PictureEntity::fileName, "file_name"),
        Pair(PictureEntity::path, "path"),
        Pair(PictureEntity::createdAt, "created_at"),
    )
): DBEntity
