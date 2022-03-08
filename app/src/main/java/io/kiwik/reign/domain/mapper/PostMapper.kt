package io.kiwik.reign.domain.mapper

import io.kiwik.reign.domain.entities.Post
import io.kiwik.reign.domain.model.PostModel
import io.kiwik.reign.ui.util.DateUtil
import io.kiwik.reign.utilities.defaultDateFormat

class PostMapper {

    fun transformToPost(list: List<PostModel>): List<Post> {
        val posts = mutableListOf<Post>()
        list.forEach {
            posts.add(transformPostModelToPost(it))
        }
        return posts
    }

    private fun transformPostModelToPost(postModel: PostModel): Post {
        val author = postModel.author ?: ""
        val storyText= postModel.storyText ?: ""
        val title = postModel.title ?: postModel.storyTitle ?: ""
        val url = postModel.storyUrl ?: postModel.url ?: ""
        return Post(
            postModel.storyId,
            author,
            storyText,
            title,
            url,
            DateUtil.parseDate(defaultDateFormat,postModel.createdAt)
        )
    }

}