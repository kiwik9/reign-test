package io.kiwik.reign.domain.model

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PostModel(
    @SerializedName("created_at") var createdAt: String,
    @SerializedName("title") var title: String? = null,
    @SerializedName("url") var url: String? = null,
    @SerializedName("author") var author: String? = null,
    @SerializedName("points") var points: String? = null,
    @SerializedName("story_text") var storyText: String? = null,
    @SerializedName("comment_text") var commentText: String? = null,
    @SerializedName("num_comments") var numComments: String? = null,
    @SerializedName("story_id") var storyId: Int,
    @SerializedName("story_title") var storyTitle: String? = null,
    @SerializedName("story_url") var storyUrl: String? = null,
    @SerializedName("parent_id") var parentId: Int? = null,
    @SerializedName("created_at_i") var createdAtI: Int? = null,
    @SerializedName("_tags") var tags: ArrayList<String> = arrayListOf(),
    @SerializedName("objectID") var objectID: String? = null
)