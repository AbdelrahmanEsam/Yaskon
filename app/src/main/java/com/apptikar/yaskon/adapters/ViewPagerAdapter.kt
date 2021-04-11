package com.apptikar.yaskon.adapters

import android.content.Context
import android.graphics.Bitmap
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide

class ViewPagerAdapter(var context: Context,var  bitmap: Bitmap) : PagerAdapter() {



    override fun getCount(): Int {
        TODO("Not yet implemented")
    }


    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
       val image  = ImageView(context)
       Glide.with(context).load(bitmap).into(image)
        container.addView(image)
        return image
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}