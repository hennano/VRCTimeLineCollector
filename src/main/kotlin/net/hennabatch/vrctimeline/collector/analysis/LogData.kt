package net.hennabatch.vrctimeline.collector.analysis

import java.time.LocalDate
import java.time.LocalTime

data class LogData(
    val date: LocalDate,
    val time: LocalTime,
    val logType: String,
    val message: String
)
