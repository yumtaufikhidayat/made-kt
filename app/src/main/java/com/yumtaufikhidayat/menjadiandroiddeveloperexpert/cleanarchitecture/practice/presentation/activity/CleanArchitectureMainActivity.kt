package com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.practice.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.practice.presentation.viewmodel.MainViewModel
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.practice.presentation.viewmodel.MainViewModelFactory
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.databinding.ActivityMainCleanArchitectureBinding

class CleanArchitectureMainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainCleanArchitectureBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setData()
    }

    private fun setData() {
        val factory = MainViewModelFactory.getInstance()
        val viewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]
        viewModel.apply {
            setName("Dicoding")
            message.observe(this@CleanArchitectureMainActivity) {
                binding.tvWelcome.text = it.welcomeMessage
            }
        }
    }
}