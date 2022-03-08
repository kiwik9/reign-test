package io.kiwik.reign.repository

import io.kiwik.reign.domain.api.ApiUtils
import io.kiwik.reign.domain.api.PostResponse
import io.kiwik.reign.domain.entities.Post

class PostRepository : BaseRepository() {

    suspend fun insertPost(vararg post: Post) = dataDao.insert(*post)
    fun getPost() = dataDao.getPost()

    suspend fun getPostFromServer(): PostResponse? {
        val iRestService = ApiUtils.getCurrentRestService()
        val response = iRestService.getPost("mobile")
        if (!response.isSuccessful) {
            return null
        }
        return response.body()
    }

}