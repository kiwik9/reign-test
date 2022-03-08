package io.kiwik.reign.domain.api

import com.squareup.moshi.*
import io.kiwik.reign.utilities.toDateTime
import org.joda.time.DateTime

class CustomDateTimeAdapter : JsonAdapter<DateTime>() {
    @FromJson
    override fun fromJson(reader: JsonReader): DateTime? {
        return try {
            val dateAsString = reader.nextString()
            dateAsString.toDateTime(SERVER_FORMAT)
        } catch (e: Exception) {
            reader.nextNull()
        }
    }

    @ToJson
    override fun toJson(writer: JsonWriter, value: DateTime?) {
        if (value != null) {
            writer.value(value.toString(SERVER_FORMAT))
        } else {
            writer.nullValue()
        }
    }

    companion object {
        const val SERVER_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ"
    }
}
