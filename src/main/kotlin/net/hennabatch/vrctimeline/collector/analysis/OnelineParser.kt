package net.hennabatch.vrctimeline.collector.analysis

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class OnelineParser{

    //1行受け取ってLogData形式で返す
    internal fun parse(line: String): LogData?{
        val messages = line.split(' ')
        val dateTime = java.lang.String.join(messages[0], " ", messages[1]).toDateTime() ?: return  null
        val logType = messages[2]
        val message = messages.slice(3 until messages.size).joinToString(" ")

        return LogData(dateTime, logType, message)
    }

    private fun String.toDateTime(pattern: String = "yyyy.MM.dd hh:mm:ss"): LocalDateTime? {
        val formatter = DateTimeFormatter.ofPattern(pattern)
        return LocalDateTime.parse(this, formatter)
    }

}