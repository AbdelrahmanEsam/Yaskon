package com.apptikar.yaskon.registration

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.apptikar.yaskon.R
import com.apptikar.yaskon.adapters.CitiesAdapter
import com.apptikar.yaskon.adapters.SpacesItemDecorationVisitedCities
import com.apptikar.yaskon.databinding.FragmentCitiesBinding
import com.apptikar.yaskon.pojos.City
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent


class Cities : Fragment() {
    private  lateinit var binding: FragmentCitiesBinding
    private lateinit var recycleradapter: CitiesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCitiesBinding.inflate(layoutInflater)
        recycler()

        binding.onBoardingContinue.setOnClickListener {
            (activity as OnBoarding).navigateToBudgetRange()
        }
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        (activity as OnBoarding).binding.pageNumber.text = "1/2"
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
        val layoutManager =  FlexboxLayoutManager(requireContext())
        layoutManager.flexDirection = FlexDirection.ROW
        layoutManager.justifyContent = JustifyContent.SPACE_BETWEEN
        binding.citiesRecycler.layoutManager = layoutManager
        binding.citiesRecycler.adapter = recycleradapter
        binding.citiesRecycler.addItemDecoration(SpacesItemDecorationVisitedCities(5))

    }
}