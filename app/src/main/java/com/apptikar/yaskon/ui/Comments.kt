package com.apptikar.yaskon.ui

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.apptikar.yaskon.R
import com.apptikar.yaskon.adapters.CommentsAdapter
import com.apptikar.yaskon.databinding.ActivityCommentsBinding
import com.apptikar.yaskon.pojos.CommentsPojo


class Comments : AppCompatActivity() {
    private lateinit var commentsRecyclerAdapter: CommentsAdapter
    private  lateinit var binding: ActivityCommentsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCommentsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recycler()
    }

    private fun dummy(): MutableList<CommentsPojo> {
        val comments :MutableList<CommentsPojo> = ArrayList()
        comments.add(CommentsPojo(customerImage = BitmapFactory.decodeResource(resources, R.drawable.cresu), customerName = "Salem Ahmed", place = "Dakahlia, Mansoura", comment = "Apartments in Ali Al Sibai St. 250 M² super lux For Rent, I need help with that"))
        comments.add(CommentsPojo(customerImage = BitmapFactory.decodeResource(resources, R.drawable.cresu), customerName = "Salem Ahmed", place = "Dakahlia, Mansoura", comment = "Apartments in Ali Al Sibai St. 250 M² super lux For Rent, I need help with that"))
        comments.add(CommentsPojo(customerImage = BitmapFactory.decodeResource(resources, R.drawable.cresu), customerName = "Salem Ahmed", place = "Dakahlia, Mansoura", comment = "Apartments in Ali Al Sibai St. 250 M² super lux For Rent, I need help with that"))
        comments.add(CommentsPojo(customerImage = BitmapFactory.decodeResource(resources, R.drawable.cresu), customerName = "Salem Ahmed", place = "Dakahlia, Mansoura", comment = "Apartments in Ali Al Sibai St. 250 M² super lux For Rent, I need help with that"))
        comments.add(CommentsPojo(customerImage = BitmapFactory.decodeResource(resources, R.drawable.cresu), customerName = "Salem Ahmed", place = "Dakahlia, Mansoura", comment = "Apartments in Ali Al Sibai St. 250 M² super lux For Rent, I need help with that"))
        comments.add(CommentsPojo(customerImage = BitmapFactory.decodeResource(resources, R.drawable.cresu), customerName = "Salem Ahmed", place = "Dakahlia, Mansoura", comment = "Apartments in Ali Al Sibai St. 250 M² super lux For Rent, I need help with that"))
        return comments
    }

    private fun recycler() {
        commentsRecyclerAdapter = CommentsAdapter(this)
        commentsRecyclerAdapter.setDataAdapter(dummy())
        val linear = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.commentsRecycler.layoutManager = linear
        binding.commentsRecycler.adapter = commentsRecyclerAdapter
    }
}