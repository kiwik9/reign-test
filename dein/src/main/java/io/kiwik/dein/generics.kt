package io.kiwik.dein

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.KoinComponent
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.core.get
import org.koin.core.inject
import org.koin.core.qualifier.named
import org.koin.dsl.ModuleDeclaration
import org.koin.dsl.module
import kotlin.reflect.full.primaryConstructor

interface AppModule : KoinComponent {
    fun initialize()
}

open class BaseApplication(context: Context) : KoinComponent {
    init {
        startKoin {
            androidLogger()
            androidContext(context)
        }
    }

    inline fun <reified T : AppModule> useModule(
        module: T,
        noinline init: (T.() -> Unit)? = null
    ): T {
        init?.let { module.it() }
        module.initialize()
        loadKoinModule {
            single(definition = { module })
        }
        return get()
    }

    inline fun <reified T : AppModule> useModule(noinline init: (T.() -> Unit)? = null): T {
        return useModule(T::class.primaryConstructor!!.call(), init)
    }

}

fun loadKoinModule(
    createdAtStart: Boolean = false,
    override: Boolean = false,
    moduleDeclaration: ModuleDeclaration
) =
    module(createdAtStart, override, moduleDeclaration).apply {
        loadKoinModules(this)
    }


abstract class InjectListModule<T> : AppModule {
    val items: MutableList<T> = mutableListOf()

    open fun add(vararg objs: T) {
        items.addAll(objs)
    }
}

inline fun <reified T : ViewModel> LifecycleOwner.namedViewModel() =
    viewModel<T>(named(T::class.simpleName!!))


inline fun <reified T> KoinComponent.namedInject() = inject<T>(named(T::class.simpleName!!))