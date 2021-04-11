package com.apptikar.yaskon


import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.apptikar.yaskon.adapters.CitiesAdapter
import com.apptikar.yaskon.adapters.SpacesItemDecoration
import com.apptikar.yaskon.databinding.ActivityVisitCitiesBinding
import com.apptikar.yaskon.pojos.City



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
return cities
    }

    private fun recycler() {
        recycleradapter = CitiesAdapter()
        val dummy = dummy()
        recycleradapter.setDataAdapter(dummy)
        val grid = GridLayoutManager(this, 2)
        binding.citiesRecycler.layoutManager = grid
        binding.citiesRecycler.adapter = recycleradapter
        binding.citiesRecycler.addItemDecoration(SpacesItemDecoration(10))
    }
}