package io.kiwik.reign.di

import android.util.Log
import io.kiwik.dein.AppModule
import io.kiwik.dein.BaseApplication
import io.kiwik.dein.InjectListModule
import io.kiwik.dein.loadKoinModule
import io.kiwik.dein.modules.ViewModelModule
import io.kiwik.reign.domain.db.AppDatabase
import io.kiwik.reign.repository.BaseRepository
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.bind

class RepositoryModule : InjectListModule<BaseRepository>() {
    private val TAG = this::class.java.simpleName
    override fun initialize() {
        loadKoinModule {
            items.forEach { repo ->
                single(named(repo::class.simpleName!!)) { repo }.bind(repo::class).also {
                    Log.i("[Koin]:$TAG", "Loading: $it")
                }
            }
        }
    }
}

class AppDatabaseModule : AppModule {
    private val TAG = this::class.java.simpleName
    override fun initialize() {
        loadKoinModule {
            single { AppDatabase.buildDatabase(androidContext()) }.also {
                Log.i("[Koin]:$TAG", "Loading: $it")
            }
        }
    }
}


fun BaseApplication.useViewModels(init: (ViewModelModule.() -> Unit)? = null) = useModule(init)
fun BaseApplication.useRepository(init: (RepositoryModule.() -> Unit)? = null) = useModule(init)
fun BaseApplication.useAppDatabase(init: (AppDatabaseModule.() -> Unit)? = null): AppDatabaseModule {
    return useModule(init)
}