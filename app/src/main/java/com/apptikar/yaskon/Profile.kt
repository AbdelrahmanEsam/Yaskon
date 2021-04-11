package com.apptikar.yaskon

import android.content.Context
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.apptikar.yaskon.adapters.ViewPagerAdapter
import com.apptikar.yaskon.databinding.FragmentProfileBinding


class Profile : Fragment() {

    private lateinit var binding: FragmentProfileBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentProfileBinding.inflate(layoutInflater)
        val viewPager = ViewPagerAdapter(requireContext(), BitmapFactory.decodeResource(requireContext().resources, R.drawable.dummy4))
        binding.profileViewPager.adapter = viewPager

        return binding.root
    }

}