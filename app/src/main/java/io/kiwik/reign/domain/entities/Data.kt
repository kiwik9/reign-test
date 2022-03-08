package io.kiwik.reign.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Entity(tableName = "m_data")
data class Data(
    @PrimaryKey(autoGenerate = true)
    val id: Int
)
