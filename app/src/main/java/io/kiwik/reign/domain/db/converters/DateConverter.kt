package io.kiwik.reign.domain.db.converters

import androidx.room.TypeConverter
import io.kiwik.reign.ui.util.DateUtil
import io.kiwik.reign.utilities.defaultDateFormat
import org.joda.time.DateTime

class DateConverter {
    private val FORMAT = defaultDateFormat

    @TypeConverter
    fun fromString(value: String?): DateTime? {
        return if (value == null) null else DateUtil.parseDate(FORMAT, value)
    }

    @TypeConverter
    fun dateToString(date: DateTime?): String? {
        return date?.toString(FORMAT)
    }
}