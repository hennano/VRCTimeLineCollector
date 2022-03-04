package net.hennabatch.vrctimeline.collector.db.entity

import org.komapper.annotation.*
import java.time.LocalDateTime

@KomapperEntity
data class PictureEntity(
    @KomapperId
    @KomapperAutoIncrement
    @KomapperColumn(name = "picture_id")
    val id: Int,

    @KomapperColumn(name = "file_name")
    val fileName: String,

    @KomapperColumn(name = "path")
    val path: String,

    @KomapperCreatedAt
    @KomapperColumn(name = "created_at")
    val createdAt: LocalDateTime? = null
)