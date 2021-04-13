package com.apptikar.yaskon


import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.apptikar.yaskon.adapters.CitiesAdapter
import com.apptikar.yaskon.adapters.SpacesItemDecoration
import com.apptikar.yaskon.databinding.ActivityVisitCitiesBinding
import com.apptikar.yaskon.pojos.City
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent


class VisitCities : AppCompatActivity() {
    private  lateinit var binding: ActivityVisitCitiesBinding
    private lateinit var recycleradapter: CitiesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            binding = ActivityVisitCitiesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recycler()
    }

    private fun dummy(): MutableList<City> {
        val cities :MutableList<City> = ArrayList()
        cities.add(City("cairo", BitmapFactory.decodeResource(resources, R.drawable.f)))
        cities.add(City("alexandria", BitmapFactory.decodeResource(resources, R.drawable.g)))
        cities.add(City("dahab", BitmapFactory.decodeResource(resources, R.drawable.h)))
        cities.add(City("sharm el sheihk", BitmapFactory.decodeResource(resources, R.drawable.i)))
        cities.add(City("sharm el sheihk", BitmapFactory.decodeResource(resources, R.drawable.i)))
        return cities
    }

    private fun recycler() {
        recycleradapter = CitiesAdapter()
        recycleradapter.data = dummy()
        val layoutManager =  FlexboxLayoutManager(this)
        layoutManager.flexDirection = FlexDirection.ROW
        layoutManager.justifyContent = JustifyContent.SPACE_BETWEEN
        binding.citiesRecycler.layoutManager = layoutManager
        binding.citiesRecycler.adapter = recycleradapter
        binding.citiesRecycler.addItemDecoration(SpacesItemDecoration(5))

    }
}