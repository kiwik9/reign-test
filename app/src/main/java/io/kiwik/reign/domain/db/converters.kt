package io.kiwik.reign.domain.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import java.util.*

class JsonConverter {

    @TypeConverter
    fun fromString(value: String): HashMap<String, Any> {
        val listType = object : TypeToken<HashMap<String, Any>>() {

        }.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun mapToString(data: HashMap<String, Any>): String {
        return Gson().toJson(data)
    }

}


class DateConverter {
    val FORMAT = "yyyy-MM-dd HH:mm"

    @TypeConverter
    fun fromTimestamp(value: String?): DateTime? {
        val format = DateTimeFormat.forPattern(FORMAT)
        return if (value == null) null else format.parseDateTime(value)
    }

    @TypeConverter
    fun dateToTimestamp(date: DateTime?): String? {
        return date?.toString(FORMAT)
    }

}