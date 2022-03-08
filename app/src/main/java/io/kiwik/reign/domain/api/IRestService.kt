package io.kiwik.reign.domain.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface IRestService {
    @POST("auth/login")
    suspend fun login(@Body body: LoginRequest): LoginResponse
}
