package io.kiwik.reign.domain.api

import android.text.TextUtils
import com.squareup.moshi.Moshi
import io.kiwik.reign.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.IOException
import java.net.InetAddress
import java.net.Socket
import java.net.UnknownHostException
import java.util.concurrent.TimeUnit
import javax.net.ssl.SSLSocket
import javax.net.ssl.SSLSocketFactory

object RetrofitClient {

    var TAG: String = RetrofitClient::class.java.simpleName
    private var BASE_URL = BuildConfig.BASE_URL + "/api/"

    lateinit var retrofit: Retrofit
    private val moshi = Moshi.Builder().add(
        CustomDateTimeAdapter()
    ).build()
    private val logging = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)

    private val okHttpClient =
        OkHttpClient.Builder().connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)


    private var builder: Retrofit.Builder = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))

    fun <S> create(serviceClass: Class<S>): S {
        return create(serviceClass, "", "")

    }

    fun <S> createAuthToken(serviceClass: Class<S>, typeAuth: String, tokenAuth: String): S {
        return create(serviceClass, typeAuth, tokenAuth)
    }

    private fun <S> create(serviceClass: Class<S>, typeAuth: String, tokenAuth: String): S {
        okHttpClient.interceptors()
            .clear()
        okHttpClient.addInterceptor(logging)

        if (!TextUtils.isEmpty(tokenAuth)) {
            val authInterceptor = AuthenticationInterceptor(typeAuth, tokenAuth)
            if (!okHttpClient.interceptors().contains(authInterceptor)) {
                okHttpClient.addInterceptor(authInterceptor)
            }
        }
        builder.client(okHttpClient.build())

        retrofit = builder.build()
        return retrofit.create(serviceClass)
    }

    private class AuthenticationInterceptor(
        private val typeAuth: String,
        private val authToken: String
    ) : Interceptor {

        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response {
            val original = chain.request()

            val builder = original.newBuilder()
            builder.header("Accept", "application/json")
            setAuthHeader(builder, authToken, typeAuth)
            val request = builder.build()
            return chain.proceed(request)
        }
    }

    private fun setAuthHeader(builder: Request.Builder, authToken: String?, typeAuth: String) {
        if (authToken != null) {
            builder.header("Authorization", "$typeAuth $authToken")
        }
    }

}