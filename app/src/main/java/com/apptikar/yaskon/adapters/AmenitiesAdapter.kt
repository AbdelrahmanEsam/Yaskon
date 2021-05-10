package com.apptikar.yaskon.adapters

import android.content.Context
import android.graphics.BitmapFactory
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.apptikar.yaskon.R
import com.apptikar.yaskon.pojos.Amenities
import java.util.ArrayList

class AmenitiesAdapter(val context: Context, private val listener : OnAmenityListener): RecyclerView.Adapter<AmenitiesAdapter.ViewHolder>() {
    var data: List<Amenities> = ArrayList()
   inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),View.OnClickListener
    {
        init {
            itemView.setOnClickListener(this)

        }
        var  amenityTextView : TextView = itemView.findViewById(R.id.amenityTextView)
        var  amenityCheckBox : ImageView = itemView.findViewById(R.id.amenityCheckBox)
        override fun onClick(p0: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onAmenityClicked(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.amenities, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.apply {
         amenityTextView.text = data[position].amenityName
         if (data[position].checked){ amenityCheckBox.setImageResource(R.drawable.ic_checked) }else{amenityCheckBox.setImageResource(R.drawable.ic_unchecked)}
        }


    }

    override fun getItemCount(): Int {
        return  if(data.isNotEmpty())  data.size else 0
    }

    fun setDataAdapter(data:List<Amenities>) {
        this.data = data
        notifyDataSetChanged()
    }


    interface OnAmenityListener
    {
        fun onAmenityClicked(position: Int)
    }
}
