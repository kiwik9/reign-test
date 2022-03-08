package io.kiwik.reign.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.squareup.moshi.JsonClass
import io.kiwik.reign.domain.db.converters.DateConverter
import io.kiwik.reign.ui.util.DateUtil
import org.joda.time.DateTime
import org.joda.time.Duration

@JsonClass(generateAdapter = true)
@Entity(tableName = "m_post")
@TypeConverters(DateConverter::class)
data class Post(
    @PrimaryKey
    var storyId: Int,
    var author: String,
    var storyText: String,
    var storyTitle: String,
    var storyUrl: String,
    var createdAt: DateTime
) {
    fun getDifDate(): String {
        val diff = Duration(createdAt, DateTime.now())
        val minutes = diff.standardMinutes
        val hours = diff.standardHours
        return when {
            minutes < 60 -> "$minutes m."
            hours <= 24 -> "$hours h. ${minutes - (hours * 60)} m."
            hours <= 48 -> "Ayer"
            else -> return DateUtil.getFormatDateString(date = createdAt)
        }
    }
}
