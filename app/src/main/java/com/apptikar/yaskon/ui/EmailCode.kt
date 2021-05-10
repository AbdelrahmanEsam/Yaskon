package com.apptikar.yaskon.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.apptikar.yaskon.R
import com.apptikar.yaskon.databinding.ActivityEmailCodeBinding

class EmailCode : AppCompatActivity() {
    private val viewModel: EmailCodeViewModel by viewModels()
    private  lateinit var binding: ActivityEmailCodeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_email_code)
        binding.viewModel   = viewModel

    }
}