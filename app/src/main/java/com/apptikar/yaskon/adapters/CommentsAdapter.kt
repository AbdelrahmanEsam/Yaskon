package com.apptikar.yaskon.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.apptikar.yaskon.R
import com.apptikar.yaskon.pojos.CommentsPojo
import com.bumptech.glide.Glide
import java.util.ArrayList

class CommentsAdapter(var context: Context) : RecyclerView.Adapter<CommentsAdapter.ViewHolder>() {
    var data: List<CommentsPojo> = ArrayList()
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val  customerImage : ImageView = itemView.findViewById(R.id.profile_image_comment)
        val  customerName : TextView = itemView.findViewById(R.id.commentNameTextView)
        val  place : TextView = itemView.findViewById(R.id.commentPlaceTextView)
        val  comment : TextView = itemView.findViewById(R.id.commentTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.comment_temp, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.apply {
            Glide.with(context).load(data[position].customerImage).centerCrop().into(customerImage)
            customerName.text = data[position].customerName
            place.text = data[position].place
            comment.text = data[position].comment
        }

    }

    override fun getItemCount(): Int {
        return  if(data.isNotEmpty())  data.size else 0
    }

    fun setDataAdapter(data:List<CommentsPojo>) {
        this.data = data
        notifyDataSetChanged()
    }
}