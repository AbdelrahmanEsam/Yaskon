package com.apptikar.yaskon

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.apptikar.yaskon.adapters.DemandsAdapter
import com.apptikar.yaskon.databinding.ActivityListingBinding
import com.apptikar.yaskon.pojos.Demands


class Listing : AppCompatActivity() {
    private lateinit var recyclerAdapter: DemandsAdapter
    private  lateinit var binding: ActivityListingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recycler()
    }

    private fun dummy(): MutableList<Demands> {
        val demands :MutableList<Demands> = ArrayList()
        demands.add(
            Demands(
                customerImage = BitmapFactory.decodeResource(
                    resources,
                    R.drawable.cresu
                ),
                customerName = "Salem Ahmed",
                duration = "3 days",
                place = "Dakahlia, Mansoura",
                demand = "Apartments in Ali Al Sibai St. 250 M² super lux For Rent, I need help with that",
                numberOfComments = "12 Comments"
            )
        )
        demands.add(
            Demands(
                customerImage = BitmapFactory.decodeResource(
                    resources,
                    R.drawable.cresu
                ),
                customerName = "Salem Ahmed",
                duration = "8 days",
                place = "Dakahlia, Mansoura",
                demand = "Apartments in Ali Al Sibai St. 250 M² super lux For Rent, I need help with that",
                numberOfComments = "13 Comments"
            )
        )
        demands.add(
            Demands(
                customerImage = BitmapFactory.decodeResource(
                    resources,
                    R.drawable.cresu
                ),
                customerName = "Salem Ahmed",
                duration = "6 days",
                place = "Dakahlia, Mansoura",
                demand = "Apartments in Ali Al Sibai St. 250 M² super lux For Rent, I need help with that",
                numberOfComments = "15 Comments"
            )
        )
        demands.add(Demands(customerImage = BitmapFactory.decodeResource(resources, R.drawable.cresu), customerName = "Salem Ahmed", duration = "5 days", place = "Dakahlia, Mansoura", demand = "Apartments in Ali Al Sibai St. 250 M² super lux For Rent, I need help with that", numberOfComments = "14 Comments"))
        demands.add(Demands(customerImage = BitmapFactory.decodeResource(resources, R.drawable.cresu), customerName = "Salem Ahmed", duration = "5 days", place = "Dakahlia, Mansoura", demand = "Apartments in Ali Al Sibai St. 250 M² super lux For Rent, I need help with that", numberOfComments = "14 Comments"))
        demands.add(Demands(customerImage = BitmapFactory.decodeResource(resources, R.drawable.cresu), customerName = "Salem Ahmed", duration = "5 days", place = "Dakahlia, Mansoura", demand = "Apartments in Ali Al Sibai St. 250 M² super lux For Rent, I need help with that", numberOfComments = "14 Comments"))
        return demands
    }

    private fun recycler() {
        recyclerAdapter = DemandsAdapter(this)
        recyclerAdapter.setDataAdapter(dummy())
        val linear = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.communityRecycler.layoutManager = linear
        binding.communityRecycler.adapter = recyclerAdapter
        val itemDecorator = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        ContextCompat.getDrawable(this, R.drawable.divider)?.let { itemDecorator.setDrawable(it) }
        binding.communityRecycler.addItemDecoration(itemDecorator)
    }
}