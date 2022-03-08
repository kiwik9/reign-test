package io.kiwik.reign.utilities

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import io.kiwik.reign.domain.api.CustomDateTimeAdapter

object MoshiUtil {
    val instance: Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .add(CustomDateTimeAdapter())
        .build()
}