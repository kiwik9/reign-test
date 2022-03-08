package io.kiwik.reign.ui.activity

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import io.kiwik.reign.domain.preference.AppSession

open class BaseActivity : AppCompatActivity() {

    val session: AppSession by lazy {
        AppSession.getInstance()
    }

    fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}