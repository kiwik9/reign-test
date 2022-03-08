package io.kiwik.reign

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import io.kiwik.dein.BaseApplication
import io.kiwik.reign.di.useAppDatabase
import io.kiwik.reign.di.useRepository
import io.kiwik.reign.di.useViewModels
import io.kiwik.reign.repository.REPOSITORY_LIST
import io.kiwik.reign.viewmodel.VIEW_MODEL_LIST
import net.danlew.android.joda.JodaTimeAndroid


class MvpApp : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        JodaTimeAndroid.init(this)
        BaseApplication(this@MvpApp).apply {
            useAppDatabase()
            useRepository { add(*REPOSITORY_LIST) }
            useViewModels { add(*VIEW_MODEL_LIST) }
        }
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    companion object {
        lateinit var instance: MvpApp
            private set
    }
}