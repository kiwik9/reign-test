package io.kiwik.reign.viewmodel

import androidx.lifecycle.viewModelScope
import io.kiwik.reign.domain.mapper.PostMapper
import io.kiwik.reign.ui.listener.PostViewListener
import io.kiwik.reign.utilities.isNull
import kotlinx.coroutines.launch

class PostViewModel : BaseViewModel() {

    private lateinit var listenerPost: PostViewListener

    fun setListenerViewPost(listener: PostViewListener) {
        this.listenerPost = listener
    }

    fun getPost() = dataRepository.getPost()

    fun getPostFromServer() = viewModelScope.launch {
        val result = dataRepository.getPostFromServer()
        if (result.isNull() or result?.post.isNull()) {
            listenerPost.onErrorGetPost()
        } else {
            dataRepository.insertPost(*PostMapper().transformToPost(result!!.post!!).toTypedArray())
            listenerPost.onSuccessGetPost()
        }
    }

}