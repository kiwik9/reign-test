package io.kiwik.reign.repository

import io.kiwik.reign.domain.api.ApiUtils
import io.kiwik.reign.domain.api.PostResponse
import io.kiwik.reign.domain.entities.Post
import kotlinx.coroutines.runBlocking

class PostRepository : BaseRepository() {

    suspend fun insertPost(vararg post: Post) = dataDao.insert(*post)
    fun getPost() = dataDao.getPost()
    fun removePost(id: Int) = runBlocking { dataDao.removePost(id) }

    suspend fun getPostFromServer(): PostResponse? {
        val iRestService = ApiUtils.getCurrentRestService()
        val response = iRestService.getPost("mobile")
        if (!response.isSuccessful) {
            return null
        }
        return response.body()
    }

}