package io.kiwik.reign.domain.preference

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.squareup.moshi.JsonAdapter
import io.kiwik.reign.MvpApp
import io.kiwik.reign.utilities.MoshiUtil

class AppSession {

    private val moshi = MoshiUtil.instance
    private var preferences: SharedPreferences =
        MvpApp.instance.applicationContext.getSharedPreferences(TAG, Context.MODE_PRIVATE)
    private var adapter: JsonAdapter<SessionData> = moshi.adapter(SessionData::class.java)
    lateinit var values: SessionData

    init {
        load()
    }

    private fun load() {
        try {
            val jsonString = preferences.getString(KEY, "")
            jsonString?.let {
                values = if (it.isNotEmpty()) adapter.fromJson(it)!! else SessionData()
            }
        } catch (e: Exception) {
            Log.e(TAG, "onLoad", e)
        }

    }

    fun update() {
        try {
            val editor = preferences.edit()
            val jsonString = adapter.toJson(values)
            editor.putString(KEY, jsonString)
            editor.apply()
        } catch (e: Exception) {
            Log.e(TAG, "update", e)
        }

    }

    fun clear() {
        values.currentPost = null
        update()
    }

    companion object {

        private val TAG = AppSession::class.java.simpleName
        private val KEY = SessionData::class.java.simpleName

        private var instance: AppSession? = null

        @Synchronized
        fun getInstance(): AppSession {
            return instance ?: AppSession().also { instance = it }
        }
    }

}
