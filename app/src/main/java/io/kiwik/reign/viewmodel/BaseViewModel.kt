package io.kiwik.reign.viewmodel

import androidx.lifecycle.ViewModel
import io.kiwik.dein.namedInject
import io.kiwik.reign.repository.PostRepository
import org.koin.core.KoinComponent

abstract class BaseViewModel : ViewModel(), KoinComponent {
    val dataRepository: PostRepository by namedInject()

}

val VIEW_MODEL_LIST by lazy {
    arrayOf(
        PostViewModel()
    )
}