package com.apptikar.yaskon.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.apptikar.yaskon.R
import com.apptikar.yaskon.databinding.ActivityResetPasswordBinding

class ResetPassword : AppCompatActivity() {
    private val viewModel: ResetViewModel by viewModels()
    private  lateinit var binding: ActivityResetPasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_reset_password)
        binding.viewModel   = viewModel
    }
}