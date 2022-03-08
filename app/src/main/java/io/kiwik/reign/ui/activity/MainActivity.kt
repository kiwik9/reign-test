package io.kiwik.reign.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.kiwik.dein.namedViewModel
import io.kiwik.reign.databinding.ActivityMainBinding
import io.kiwik.reign.viewmodel.DataViewModel


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val dataViewModel: DataViewModel by namedViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}
