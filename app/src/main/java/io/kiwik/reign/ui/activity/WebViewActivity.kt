package io.kiwik.reign.ui.activity

import android.os.Bundle
import android.view.KeyEvent
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.core.view.isVisible
import io.kiwik.reign.databinding.ActivityWebViewBinding
import io.kiwik.reign.domain.entities.Post
import io.kiwik.reign.utilities.isNull

class WebViewActivity : BaseActivity() {

    private lateinit var binding: ActivityWebViewBinding
    private lateinit var currentPost: Post

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        initializeData()
        initializeWebView()
        initializeActions()
    }

    private fun initializeActions() {
        binding.btnBack.setOnClickListener {
            finish()
        }
    }

    private fun initializeWebView() {
        binding.wvContentPost.loadUrl(currentPost.storyUrl)
        binding.wvContentPost.settings.javaScriptEnabled = true
        binding.wvContentPost.settings.loadsImagesAutomatically = true
        binding.wvContentPost.settings.domStorageEnabled = true
        binding.wvContentPost.webViewClient = WebViewClient()

        binding.wvContentPost.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                binding.progressWebView.isVisible = newProgress < 100
            }
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && binding.wvContentPost.canGoBack()) {
            binding.wvContentPost.goBack()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }

    private fun initializeData() {
        val post = session.values.currentPost
        if (post.isNull()) {
            showMessage("Error al obtener el item.")
            return
        }
        currentPost = post!!
    }
}