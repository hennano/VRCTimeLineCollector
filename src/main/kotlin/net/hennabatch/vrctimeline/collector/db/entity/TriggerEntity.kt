package net.hennabatch.vrctimeline.collector.db.entity

import org.komapper.annotation.*
import java.time.LocalDateTime
import kotlin.reflect.KProperty1

@KomapperEntity
data class TriggerEntity(
    @KomapperId
    @KomapperAutoIncrement
    @KomapperColumn(name = "trigger_id")
    val id: Int = -1,

    //イベントの種類id
    @KomapperColumn(name = "event_type_id")
    val eventTypeId: Int = -1,

    //イベント発生時間
    @KomapperColumn(name = "triggered_at")
    val triggeredAt: LocalDateTime? = null,

    //逆参照用
    @KomapperIgnore
    val keyMap: Map<KProperty1<TriggerEntity, Any?>, String> = mapOf(
        Pair(TriggerEntity::id, "trigger_id"),
        Pair(TriggerEntity::eventTypeId, "event_type_id"),
        Pair(TriggerEntity::triggeredAt, "triggered_at")
    )
): DBEntity
