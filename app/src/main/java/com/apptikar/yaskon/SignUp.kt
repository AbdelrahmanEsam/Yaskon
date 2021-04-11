package com.apptikar.yaskon

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.apptikar.yaskon.databinding.ActivitySignUpBinding


class SignUp : AppCompatActivity() {
    private  lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setSpinnerCustomAdapter()
        setContentView(binding.root)
    }

    private fun setSpinnerCustomAdapter()
    {
        val countryCodes = resources.getStringArray(R.array.country)
        val arrayList = countryCodes.toSortedSet().toList()
        val adapter = ArrayAdapter(this, R.layout.custom_spinner_item2,arrayList)
        adapter.setDropDownViewResource(R.layout.custom_spinner_item2)
        binding.spinner2.adapter = adapter
    }
}