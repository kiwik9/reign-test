package io.kiwik.reign.domain.entities

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ExtraResult(
    @SerializedName("value") var value: String? = null,
    @SerializedName("matchLevel") var matchLevel: String? = null,
    @SerializedName("matchedWords") var matchedWords: ArrayList<String> = arrayListOf()
)