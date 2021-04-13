package com.apptikar.yaskon

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.apptikar.yaskon.adapters.ViewPagerAdapter
import com.apptikar.yaskon.databinding.ActivityPropertyBinding

class PropertyActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPropertyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPropertyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val dummy :MutableList<Bitmap> = ArrayList()
        dummy.add(BitmapFactory.decodeResource(resources, R.drawable.sekiro))
        dummy.add(BitmapFactory.decodeResource(resources, R.drawable.dummy5))
        val adapter = ViewPagerAdapter(this, dummy)
        binding.viewPager.addOnPageChangeListener(object : OnPageChangeListener {
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