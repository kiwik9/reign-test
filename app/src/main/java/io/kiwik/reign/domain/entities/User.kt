package io.kiwik.reign.domain.entities

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class User(
    val name: String,
    val userCode: Int
)
