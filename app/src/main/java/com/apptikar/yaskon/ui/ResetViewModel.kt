package com.apptikar.yaskon.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ResetViewModel : ViewModel() {
    val emailResetMutable = MutableLiveData<String>()
}