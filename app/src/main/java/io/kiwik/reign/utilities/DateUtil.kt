package io.kiwik.reign.utilities

import org.joda.time.DateTime
import org.joda.time.Minutes
import org.joda.time.format.DateTimeFormat
import java.util.*


fun String.toDateTime(format: String): DateTime {
    return DateTimeFormat.forPattern(format).parseDateTime(this)
}

fun Long?.toDate(): Date? {
    return if (this != null) Date(this) else null
}

fun Long?.toDateTime(): DateTime? {
    return if (this != null) DateTime(this) else null
}

/**
 * Minutos entre dos datetime
 */
operator fun DateTime.minus(other: DateTime): Int {
    return Minutes.minutesBetween(other, this).minutes
}


fun Int.dateStrDifference(): String {
    val hours = this / 60
    val minutes = this % 60
    return "hora".pluralize(hours) + " " + "minuto".pluralize(minutes)
}

/**
 * format text con plural
 * agregar soporte para "es"
 */
fun String.pluralize(count: Int, hideZeros: Boolean = false): String {
    val plural = if (count > 1) "s" else ""
    return if (hideZeros && count == 0) "" else "$count $this$plural"
}
