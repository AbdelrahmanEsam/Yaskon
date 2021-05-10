package com.apptikar.yaskon.ui

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.apptikar.yaskon.R
import com.apptikar.yaskon.adapters.ViewPagerAdapter
import com.apptikar.yaskon.databinding.FragmentPropertyBinding

class PropertyFragment : Fragment() {
     lateinit var binding:FragmentPropertyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentPropertyBinding.inflate(layoutInflater)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewPager()
    }

    private fun viewPager()
    {
        val dummy :MutableList<Bitmap> = ArrayList()
        dummy.add(BitmapFactory.decodeResource(resources, R.drawable.sekiro))
        dummy.add(BitmapFactory.decodeResource(resources, R.drawable.dummy5))
        val adapter = ViewPagerAdapter(requireContext(), dummy)
        binding.viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                binding.imageNumber.text=((position+1).toString()+"/"+dummy.size.toString())
            }
            override fun onPageSelected(position: Int) {
            }
            override fun onPageScrollStateChanged(state: Int) {}
        })
        binding.viewPager.adapter =adapter
    }

}