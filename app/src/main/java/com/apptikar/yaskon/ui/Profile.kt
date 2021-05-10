package com.apptikar.yaskon.ui

import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.apptikar.yaskon.R
import com.apptikar.yaskon.adapters.PropertyAdapter
import com.apptikar.yaskon.adapters.SpacesItemDecoration
import com.apptikar.yaskon.databinding.FragmentProfileBinding
import com.apptikar.yaskon.pojos.Apartments
import kotlinx.coroutines.*


class Profile : AppCompatActivity(){

    private lateinit var binding: FragmentProfileBinding



    override fun onCreate(savedInstanceState: Bundle?)
    {  super.onCreate(savedInstanceState)
        binding = FragmentProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }





}