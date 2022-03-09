package net.hennabatch.vrctimeline.collector.analysis.event

import net.hennabatch.vrctimeline.collector.analysis.LogData
import net.hennabatch.vrctimeline.collector.db.DBCache
import net.hennabatch.vrctimeline.collector.db.entity.DataExtractEntity
import net.hennabatch.vrctimeline.collector.db.entity.EventDetectEntity
import net.hennabatch.vrctimeline.collector.db.entity.EventTypeEntity
import java.util.concurrent.CopyOnWriteArrayList

object EventHandler {

    fun find(logData: LogData): Event? {
        val eventDetectEntity = DBCache.eventDetector.find {
            Regex(pattern = it.detectRegex).containsMatchIn(logData.message)
        } ?: return null
        return Event(logData, eventDetectEntity.copy())
    }
}