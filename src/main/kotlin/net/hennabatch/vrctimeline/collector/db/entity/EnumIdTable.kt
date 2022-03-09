package net.hennabatch.vrctimeline.collector.db.entity

import kotlin.reflect.KClass

enum class EnumIdTable(val idName: String, val entityClass:KClass<out DBEntity>) {

    PlayerID("player_id", PlayerEntity::class),
    WorldID("world_id", WorldEntity::class),
    TriggerID("trigger_id", TriggerEntity::class),
    EventTypeID("event_type_id", EventTypeEntity::class),
    ContentID("content_id", ContentEntity::class),
    TagID("tag_id", TagEntity::class),
    TagTypeID("tag_type_id", TagTypeEntity::class),
    EventDetectID("event_detect_id", EventDetectEntity::class),
    DataExtractID("data_extract_id", DataExtractEntity::class),
}