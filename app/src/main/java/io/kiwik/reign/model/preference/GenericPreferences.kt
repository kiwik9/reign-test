package io.kiwik.reign.model.preference

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.google.gson.GsonBuilder
import io.kiwik.reign.MvpApp

abstract class SessionPreference {
    open fun clear() {

    }
}

open class GenericPreferences<T: SessionPreference>(private val klass: Class<T>) {

    val TAG: String = this::class.java.simpleName

    private val preferenceKey get() = klass.simpleName
    private val gson = GsonBuilder().create()
    private val preferences: SharedPreferences

    var values: T

    init {
        preferences = MvpApp.instance.applicationContext.getSharedPreferences(TAG, Context.MODE_PRIVATE)
        val jsonString = preferences.getString(preferenceKey, null)
        values = jsonString?.let {
            gson.fromJson(jsonString, klass)
        } ?: klass.newInstance()
    }

    /**
     * Actualiza los shared preferences
     */
    open fun update() {
        try {
            val editor = preferences.edit()
            val jsonString = gson.toJson(values)
            editor.putString(preferenceKey, jsonString)
            editor.apply()
        } catch (e: Exception) {
            Log.e(TAG, "update", e)
        }

    }

    open fun clear() {
        values.clear()
        update()
    }
}
