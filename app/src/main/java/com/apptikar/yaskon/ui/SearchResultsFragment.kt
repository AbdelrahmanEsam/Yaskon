package com.apptikar.yaskon.ui

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.apptikar.yaskon.R
import com.apptikar.yaskon.adapters.PropertyAdapter
import com.apptikar.yaskon.adapters.ResultSpacesItemDecoration
import com.apptikar.yaskon.databinding.FragmentSearchResultsBinding
import com.apptikar.yaskon.pojos.Apartments
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent

class SearchResultsFragment : Fragment() {

    private lateinit var recyclerResultAdapter: PropertyAdapter
    private  lateinit var binding: FragmentSearchResultsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchResultsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        apartmentRecycler()
    }

    private fun apartmentDummy(): MutableList<Apartments> {
        val apartments :MutableList<Apartments> = ArrayList()
        apartments.add(Apartments("vensia", BitmapFactory.decodeResource(resources, R.drawable.dummy3), bedsNum = "8", bathsNum = "6", price = "450 EGP", squareSize = "700 M²",apartmentOverView = "Apartments in Ali Al Sibai St. 250 M² super lux Rent..."))
        apartments.add(Apartments("vensia", BitmapFactory.decodeResource(resources, R.drawable.dummy3), bedsNum = "10", bathsNum = "4", price = "1000 EGP", squareSize = "800 M²",apartmentOverView = "Apartments in Ali Al Sibai St. 250 M² super lux Rent..."))
        apartments.add(Apartments("vensia", BitmapFactory.decodeResource(resources, R.drawable.dummy3), bedsNum = "3", bathsNum = "6", price = "1200 EGP", squareSize = "900 M²",apartmentOverView = "Apartments in Ali Al Sibai St. 250 M² super lux Rent..."))
        apartments.add(Apartments("vensia", BitmapFactory.decodeResource(resources, R.drawable.dummy3), bedsNum = "2", bathsNum = "1", price = "200 EGP", squareSize = "200 M²",apartmentOverView = "Apartments in Ali Al Sibai St. 250 M² super lux Rent..."))
        return apartments }

    private fun apartmentRecycler() {

        recyclerResultAdapter.setDataAdapter(apartmentDummy(),"result")
        val layoutManager =  FlexboxLayoutManager(requireContext())
        layoutManager.flexDirection = FlexDirection.ROW
        layoutManager.justifyContent = JustifyContent.SPACE_BETWEEN
        binding.recyclerResult.layoutManager = layoutManager
        binding.recyclerResult.adapter = recyclerResultAdapter
        binding.recyclerResult.addItemDecoration(ResultSpacesItemDecoration(30))
    }


}