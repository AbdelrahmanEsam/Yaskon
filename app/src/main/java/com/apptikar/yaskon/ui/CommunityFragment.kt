package com.apptikar.yaskon.ui

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.apptikar.yaskon.R
import com.apptikar.yaskon.adapters.DemandsAdapter
import com.apptikar.yaskon.databinding.FragmentCommunityBinding
import com.apptikar.yaskon.pojos.Demands


class CommunityFragment : Fragment(),DemandsAdapter.OnCommentClicked {

    private lateinit var recyclerAdapter: DemandsAdapter
    private  lateinit var binding: FragmentCommunityBinding
    private lateinit var nav: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        requireActivity().window.statusBarColor = ContextCompat.getColor(requireContext(), R.color.white)
        binding =  FragmentCommunityBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nav = Navigation.findNavController(view)
        recycler()
    }

    private fun dummy(): MutableList<Demands> {
        val demands :MutableList<Demands> = ArrayList()
        demands.add(Demands(customerImage = BitmapFactory.decodeResource(resources, R.drawable.cresu), customerName = "Salem Ahmed", duration = "3 days", place = "Dakahlia, Mansoura", demand = "Apartments in Ali Al Sibai St. 250 M² super lux For Rent, I need help with that", numberOfComments = "12 Comments"))
        demands.add(Demands(customerImage = BitmapFactory.decodeResource(resources, R.drawable.cresu), customerName = "Salem Ahmed", duration = "8 days", place = "Dakahlia, Mansoura", demand = "Apartments in Ali Al Sibai St. 250 M² super lux For Rent, I need help with that", numberOfComments = "13 Comments"))
        demands.add(Demands(customerImage = BitmapFactory.decodeResource(resources, R.drawable.cresu), customerName = "Salem Ahmed",duration = "6 days", place = "Dakahlia, Mansoura", demand = "Apartments in Ali Al Sibai St. 250 M² super lux For Rent, I need help with that", numberOfComments = "15 Comments"))
        demands.add(Demands(customerImage = BitmapFactory.decodeResource(resources, R.drawable.cresu), customerName = "Salem Ahmed", duration = "5 days", place = "Dakahlia, Mansoura", demand = "Apartments in Ali Al Sibai St. 250 M² super lux For Rent, I need help with that", numberOfComments = "14 Comments"))
        demands.add(Demands(customerImage = BitmapFactory.decodeResource(resources, R.drawable.cresu), customerName = "Salem Ahmed", duration = "5 days", place = "Dakahlia, Mansoura", demand = "Apartments in Ali Al Sibai St. 250 M² super lux For Rent, I need help with that", numberOfComments = "14 Comments"))
        demands.add(Demands(customerImage = BitmapFactory.decodeResource(resources, R.drawable.cresu), customerName = "Salem Ahmed", duration = "5 days", place = "Dakahlia, Mansoura", demand = "Apartments in Ali Al Sibai St. 250 M² super lux For Rent, I need help with that", numberOfComments = "14 Comments"))
        return demands
    }

    private fun recycler() {
        recyclerAdapter = DemandsAdapter(requireContext(),this)
        recyclerAdapter.setDataAdapter(dummy())
        val linear = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.communityRecycler.layoutManager = linear
        binding.communityRecycler.adapter = recyclerAdapter
        val itemDecorator = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        ContextCompat.getDrawable(requireContext(), R.drawable.divider)?.let { itemDecorator.setDrawable(it) }
        binding.communityRecycler.addItemDecoration(itemDecorator)
    }

    override fun onCommentClicked(position: Int) {
       nav.navigate(R.id.action_communityFragment_to_commentsFragment)
    }

}