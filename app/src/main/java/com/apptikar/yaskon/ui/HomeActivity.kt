package com.apptikar.yaskon.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.apptikar.yaskon.R
import com.apptikar.yaskon.databinding.ActivityHomeLayoutBinding


class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeLayoutBinding
    private val  viewModel:SharedViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home_layout)
        setContentView(binding.root)








    }









}
