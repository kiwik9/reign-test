package io.kiwik.reign.domain.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface IRestService {
    @GET("v1/search_by_date")
    suspend fun getPost(@Query("query") query: String): Response<PostResponse>
}
