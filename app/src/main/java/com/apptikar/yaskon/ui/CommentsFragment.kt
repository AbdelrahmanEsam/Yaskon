package com.apptikar.yaskon.ui

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.apptikar.yaskon.R
import com.apptikar.yaskon.adapters.CommentsAdapter
import com.apptikar.yaskon.databinding.ActivityCommentsBinding
import com.apptikar.yaskon.databinding.FragmentCommentsBinding
import com.apptikar.yaskon.pojos.CommentsPojo

class CommentsFragment : Fragment() {

    private lateinit var commentsRecyclerAdapter: CommentsAdapter
    private  lateinit var binding: FragmentCommentsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCommentsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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
        commentsRecyclerAdapter = CommentsAdapter(requireContext())
        commentsRecyclerAdapter.setDataAdapter(dummy())
        val linear = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.commentsRecycler.layoutManager = linear
        binding.commentsRecycler.adapter = commentsRecyclerAdapter
    }


}