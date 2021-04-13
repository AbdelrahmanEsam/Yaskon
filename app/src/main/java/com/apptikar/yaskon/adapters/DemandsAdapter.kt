package com.apptikar.yaskon.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.apptikar.yaskon.R
import com.apptikar.yaskon.pojos.Demands
import com.bumptech.glide.Glide
import java.util.ArrayList

class DemandsAdapter(var context: Context) : RecyclerView.Adapter<DemandsAdapter.ViewHolder>() {
    var data: List<Demands> = ArrayList()
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var  customerImage : ImageView = itemView.findViewById(R.id.profile_image_comment)
        var  customerName : TextView = itemView.findViewById(R.id.commentNameTextView)
        var  duration : TextView = itemView.findViewById(R.id.customerDurationTextView)
        var  place : TextView = itemView.findViewById(R.id.commentPlaceTextView)
        var  demand : TextView = itemView.findViewById(R.id.commentTextView)
        var  numberOfComments : TextView = itemView.findViewById(R.id.numberOfComments)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.community, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.apply {
          Glide.with(context).load(data[position].customerImage).centerCrop().into(customerImage)
            customerName.text = data[position].customerName
            duration.text = data[position].duration
            place.text = data[position].place
            demand.text = data[position].demand
            numberOfComments.text = data[position].numberOfComments
        }

    }

    override fun getItemCount(): Int {
        return  if(data.isNotEmpty())  data.size else 0
    }

    fun setDataAdapter(data:List<Demands>) {
        this.data = data
        notifyDataSetChanged()
    }
}