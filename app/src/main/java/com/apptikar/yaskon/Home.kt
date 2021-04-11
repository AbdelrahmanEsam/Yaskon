package com.apptikar.yaskon

import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.apptikar.yaskon.adapters.*
import com.apptikar.yaskon.databinding.ActivityHomeBinding
import com.apptikar.yaskon.pojos.Apartments
import com.apptikar.yaskon.pojos.City
import com.apptikar.yaskon.pojos.PopularPlaces
import com.apptikar.yaskon.pojos.StoryHome


class Home : AppCompatActivity() {
    private lateinit var recyclerAdapter: CitiesAdapter
    private lateinit var apartmentRecyclerAdapter: ApartmentsAdapter
    private lateinit var storiesRecyclerAdapter: StoriesAdapter
    private lateinit var popularPlacesAdapter: PopularPlacesAdapter
    private lateinit var recommendedRecyclerAdapter: ApartmentsAdapter
    private  lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = getColor(R.color.orange_500)
        recycler()
        apartmentRecycler()
        storiesRecycler()
        popularRecycler()
        recommendedRecycler()
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
        recyclerAdapter = CitiesAdapter()
        recyclerAdapter.setDataAdapter(dummy())
        val linear = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.citiesRecyclerHome.layoutManager = linear
        binding.citiesRecyclerHome.adapter = recyclerAdapter
        binding.citiesRecyclerHome.addItemDecoration(SpacesItemDecoration(12))
    }

    private fun apartmentDummy(): MutableList<Apartments> {
        val apartments :MutableList<Apartments> = ArrayList()
        apartments.add(Apartments("vensia", BitmapFactory.decodeResource(applicationContext.resources, R.drawable.dummy3), bedsNum = "8", bathsNum = "6", price = "450 EGP", squareSize = "700 M²",apartmentOverView = "Apartments in Ali Al Sibai St. 250 M² super lux Rent..."))
        apartments.add(Apartments("vensia", BitmapFactory.decodeResource(resources, R.drawable.dummy3), bedsNum = "10", bathsNum = "4", price = "1000 EGP", squareSize = "800 M²",apartmentOverView = "Apartments in Ali Al Sibai St. 250 M² super lux Rent..."))
        apartments.add(Apartments("vensia", BitmapFactory.decodeResource(resources, R.drawable.dummy3), bedsNum = "3", bathsNum = "6", price = "1200 EGP", squareSize = "900 M²",apartmentOverView = "Apartments in Ali Al Sibai St. 250 M² super lux Rent..."))
        apartments.add(Apartments("vensia", BitmapFactory.decodeResource(resources, R.drawable.dummy3), bedsNum = "2", bathsNum = "1", price = "200 EGP", squareSize = "200 M²",apartmentOverView = "Apartments in Ali Al Sibai St. 250 M² super lux Rent..."))
        return apartments
    }

    private fun apartmentRecycler() {
        apartmentRecyclerAdapter = ApartmentsAdapter()
        apartmentRecyclerAdapter.setDataAdapter(apartmentDummy())
        val linear = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.placesRecyclerHome.layoutManager = linear
        binding.placesRecyclerHome.adapter = apartmentRecyclerAdapter
        binding.placesRecyclerHome.addItemDecoration(SpacesItemDecoration(30))
    }

    private fun dummyStories(): MutableList<StoryHome> {
        val stories :MutableList<StoryHome> = ArrayList()
        stories.add(StoryHome("cresu", BitmapFactory.decodeResource(resources, R.drawable.cresu)))
        stories.add(StoryHome("cresu2", BitmapFactory.decodeResource(resources, R.drawable.cresu)))
        stories.add(StoryHome("cresu3", BitmapFactory.decodeResource(resources, R.drawable.cresu)))
        stories.add(StoryHome("cresu4", BitmapFactory.decodeResource(resources, R.drawable.g)))
        stories.add(StoryHome("cresu4", BitmapFactory.decodeResource(resources, R.drawable.g)))
        return stories
    }


    private fun storiesRecycler() {
        storiesRecyclerAdapter = StoriesAdapter()
        storiesRecyclerAdapter.setDataAdapter(dummyStories())
        val linear = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.storiesRecyclerHome.layoutManager = linear
        binding.storiesRecyclerHome.adapter = storiesRecyclerAdapter
        binding.storiesRecyclerHome.addItemDecoration(SpacesItemDecoration(22))
    }

    private fun popularPlaces(): MutableList<PopularPlaces> {
        val popular :MutableList<PopularPlaces> = ArrayList()
        popular.add(PopularPlaces("vensia",place = "blue Hole", image =  BitmapFactory.decodeResource(resources, R.drawable.dummy1)))
        popular.add(PopularPlaces("vensia",place = "blue Hole", image =  BitmapFactory.decodeResource(resources, R.drawable.dummy2)))
        popular.add(PopularPlaces("vensia",place = "blue Hole", image =  BitmapFactory.decodeResource(resources, R.drawable.dummy1)))
        popular.add(PopularPlaces("vensia",place = "blue Hole", image =  BitmapFactory.decodeResource(resources, R.drawable.dummy2)))
        return popular
    }

    private fun popularRecycler() {
        popularPlacesAdapter = PopularPlacesAdapter()
        popularPlacesAdapter.setDataAdapter(popularPlaces())
        val linear = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.popularRecyclerHome.layoutManager = linear
        binding.popularRecyclerHome.adapter = popularPlacesAdapter
        binding.popularRecyclerHome.addItemDecoration(SpacesItemDecoration(20))
    }

    private fun recommendedDummy(): MutableList<Apartments> {
        val apartments :MutableList<Apartments> = ArrayList()
        apartments.add(Apartments("vensia", BitmapFactory.decodeResource(resources, R.drawable.dummy3), bedsNum = "8", bathsNum = "6", price = "450 EGP", squareSize = "700 M²",apartmentOverView = "Apartments in Ali Al Sibai St. 250 M² super lux Rent..."))
        apartments.add(Apartments("vensia", BitmapFactory.decodeResource(resources, R.drawable.dummy3), bedsNum = "10", bathsNum = "4", price = "1000 EGP", squareSize = "800 M²",apartmentOverView = "Apartments in Ali Al Sibai St. 250 M² super lux Rent..."))
        apartments.add(Apartments("vensia", BitmapFactory.decodeResource(resources, R.drawable.dummy3), bedsNum = "3", bathsNum = "6", price = "1200 EGP", squareSize = "900 M²",apartmentOverView = "Apartments in Ali Al Sibai St. 250 M² super lux Rent..."))
        apartments.add(Apartments("vensia", BitmapFactory.decodeResource(resources, R.drawable.dummy3), bedsNum = "2", bathsNum = "1", price = "200 EGP", squareSize = "200 M²",apartmentOverView = "Apartments in Ali Al Sibai St. 250 M² super lux Rent..."))
        return apartments
    }

    private fun recommendedRecycler() {
        recommendedRecyclerAdapter = ApartmentsAdapter()
        recommendedRecyclerAdapter .setDataAdapter(recommendedDummy())
        val linear = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.highlyRecommendedRecyclerHome.layoutManager = linear
        binding.highlyRecommendedRecyclerHome.adapter = recommendedRecyclerAdapter
        binding.highlyRecommendedRecyclerHome.addItemDecoration(SpacesItemDecoration(30))
    }
}