package io.kiwik.reign.domain.api

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.JsonClass
import io.kiwik.reign.domain.model.PostModel

@JsonClass(generateAdapter = true)
data class PostResponse(
    @SerializedName("hits")
    var post: List<PostModel>?
)