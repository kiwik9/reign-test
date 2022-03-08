package io.kiwik.reign.domain.preference

import com.squareup.moshi.JsonClass
import io.kiwik.reign.domain.entities.Post

@JsonClass(generateAdapter = true)
class SessionData {
    var currentPost: Post? = null
}


