package com.apptikar.yaskon.ui
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignUpViewModel : ViewModel() {
   val nameMutable = MutableLiveData<String>()
   val emailMutable = MutableLiveData<String>()
   val passwordMutable = MutableLiveData<String>()
   val phoneNumberMutable = MutableLiveData<String>()
   val countryCodeMutable = MutableLiveData<String>()
   val accountType = MutableLiveData<String>()
   val accessToken = MutableLiveData<String>()

}