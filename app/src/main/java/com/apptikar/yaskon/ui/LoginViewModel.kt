package com.apptikar.yaskon.ui
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel :ViewModel()
{
    val emailMutable = MutableLiveData<String>()
    val passwordMutable = MutableLiveData<String>()
}