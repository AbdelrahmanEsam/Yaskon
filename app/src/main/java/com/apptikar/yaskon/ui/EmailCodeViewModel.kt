package com.apptikar.yaskon.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EmailCodeViewModel :  ViewModel()
{
    val code1 = MutableLiveData<String>()
    val code2 = MutableLiveData<String>()
    val code3 = MutableLiveData<String>()
    val code4 = MutableLiveData<String>()

}