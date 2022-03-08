package io.kiwik.reign.domain.api.exception

import android.text.TextUtils
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class ApiError {

    var statusCode: Int = 0

    @Json(name = "error_description")
    var errorDescription: String? = null
    var message: String? = null
    var results: String? = null
    var detail: String? = null

    fun status(): Int {
        return statusCode
    }

    fun message(): String? {
        return if (!TextUtils.isEmpty(errorDescription)) {
            errorDescription
        } else if (!TextUtils.isEmpty(message)) {
            message
        } else if (!TextUtils.isEmpty(results)) {
            results
        } else {
            detail
        }
    }

}

