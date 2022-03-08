package io.kiwik.dein.modules

import android.util.Log
import androidx.lifecycle.ViewModel
import io.kiwik.dein.InjectListModule
import io.kiwik.dein.loadKoinModule
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.bind

class ViewModelModule: InjectListModule<ViewModel>() {
    private val TAG = this::class.java.simpleName
    override fun initialize() {
        loadKoinModule {
            items.forEach { vm ->
                viewModel(named(vm::class.simpleName!!)) { vm }.bind(vm::class).also {
                    Log.i("[Koin]:$TAG", "Loading: $it")
                }
            }
        }
    }
}