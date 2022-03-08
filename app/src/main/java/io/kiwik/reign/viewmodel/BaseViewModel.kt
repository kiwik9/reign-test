package io.kiwik.reign.viewmodel

import androidx.lifecycle.ViewModel
import io.kiwik.dein.namedInject
import io.kiwik.reign.repository.DataRepository
import org.koin.core.KoinComponent

abstract class BaseViewModel : ViewModel(), KoinComponent {
    val dataRepository: DataRepository by namedInject()

}

val VIEW_MODEL_LIST by lazy {
    arrayOf(
        DataViewModel()
    )
}