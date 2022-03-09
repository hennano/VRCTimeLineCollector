package net.hennabatch.vrctimeline.collector.db.entity

import org.komapper.annotation.*
import kotlin.reflect.KProperty1

@KomapperEntity
data class DataExtractEntity(

    @KomapperId
    @KomapperAutoIncrement
    @KomapperColumn(name = "data_extract_id")
    val id: Int = -1,

    @KomapperColumn(name = "event_detect_id")
    val eventDetectorId: Int = -1,

    @KomapperColumn(name = "extract_regex")
    val extractRegex: String = "",

    @KomapperColumn(name = "bind_id_type")
    val bindIdType: String,

    @KomapperColumn(name = "bind_column_type")
    val bindColumnType: String,

    @KomapperIgnore
    val keyMap: Map<KProperty1<DataExtractEntity, Any?>, String> = mapOf(
        Pair(DataExtractEntity::id, "data_extract_id"),
        Pair(DataExtractEntity::eventDetectorId, "event_detect_id"),
        Pair(DataExtractEntity::extractRegex, "extract_regex"),
        Pair(DataExtractEntity::bindIdType, "bind_id_type"),
        Pair(DataExtractEntity::bindColumnType, "bind_column_type")
    )
):DBEntity
