package com.apptikar.yaskon.registration
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.apptikar.yaskon.ui.LoginViewModel
import com.apptikar.yaskon.R
import com.apptikar.yaskon.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {
    private val viewModel: LoginViewModel by viewModels()
    private  lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.viewModel   = viewModel


    }
}