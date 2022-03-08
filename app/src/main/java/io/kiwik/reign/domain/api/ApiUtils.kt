package io.kiwik.reign.domain.api

object ApiUtils {
    private var iRestService: IRestService? = null

    fun getCurrentRestService(): IRestService {
        return iRestService ?: buildIRestService().also { iRestService = it }
    }

    private fun buildIRestService(): IRestService {
        return RetrofitClient.create(IRestService::class.java)
    }
}
