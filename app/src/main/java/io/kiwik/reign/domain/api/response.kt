package io.kiwik.reign.domain.api

import io.kiwik.reign.domain.entities.User

data class LoginResponse(
    var token: String,
    var message: String,
    var status: String,
    var user: User
)