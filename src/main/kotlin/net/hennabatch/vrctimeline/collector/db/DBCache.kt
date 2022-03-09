package net.hennabatch.vrctimeline.collector.db

import net.hennabatch.vrctimeline.collector.analysis.LogData
import net.hennabatch.vrctimeline.collector.analysis.event.Event
import net.hennabatch.vrctimeline.collector.db.entity.DataExtractEntity
import net.hennabatch.vrctimeline.collector.db.entity.EventDetectEntity
import net.hennabatch.vrctimeline.collector.db.entity.EventTypeEntity
import java.util.concurrent.CopyOnWriteArrayList

object DBCache {

    val eventDetector = CopyOnWriteArrayList<EventDetectEntity>()

    val eventType = CopyOnWriteArrayList<EventTypeEntity>()

    val dataExtractor = CopyOnWriteArrayList<DataExtractEntity>()

    fun update(){

    }
}