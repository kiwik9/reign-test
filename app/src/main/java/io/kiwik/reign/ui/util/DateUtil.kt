package io.kiwik.reign.ui.util

import io.kiwik.reign.utilities.defaultDateFormat
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import java.util.*

class DateUtil {
    companion object {
        fun getFormatDateString(
            date: DateTime,
            format: String = defaultDateFormat,
            locale: Locale = Locale("es", "ES")
        ): String {
            val formatter = DateTimeFormat.forPattern(format).withLocale(locale)
            return formatter.print(date)
        }

        fun parseDate(format: String, date: String): DateTime {
            return DateTimeFormat.forPattern(format).parseDateTime(date)
        }

        fun parseMillis(long: Long?) : DateTime {
            return DateTime(long)
        }
    }

}