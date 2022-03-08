package io.kiwik.reign.domain.api

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LoginRequest(
    var username: String,
    val password: Int
)