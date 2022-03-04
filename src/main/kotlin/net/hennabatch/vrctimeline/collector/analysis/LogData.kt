package net.hennabatch.vrctimeline.collector.analysis

import java.time.LocalDateTime

data class LogData(
    val dateTime: LocalDateTime,
    val logType: String,
    val message: String
)
