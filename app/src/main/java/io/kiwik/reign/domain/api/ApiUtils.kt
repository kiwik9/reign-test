package io.kiwik.reign.domain.api

import io.kiwik.reign.model.preference.AppSession

object ApiUtils {
    private var iRestService: IRestService? = null

    fun getCurrentRestService(): IRestService {
        return iRestService ?: buildIRestService().also { iRestService = it }
    }

    private fun buildIRestService(): IRestService {
        val token = AppSession.values.loggedUser?.name
            ?: return RetrofitClient.create(IRestService::class.java)
        return RetrofitClient.createAuthToken(IRestService::class.java, "Bearer", token)
    }
}