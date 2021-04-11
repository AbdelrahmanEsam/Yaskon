package com.apptikar.yaskon.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.apptikar.yaskon.R
import com.apptikar.yaskon.pojos.City
import java.util.ArrayList

class CitiesAdapter : RecyclerView.Adapter<CitiesAdapter.ViewHolder>() {
    var data: List<City> = ArrayList()
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
      var  cityNameTextView : TextView = itemView.findViewById(R.id.cityName)
      var  cityImage : ImageView = itemView.findViewById(R.id.cityImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.city_temp, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.apply {
          cityNameTextView.text = data[position].cityName
          cityImage.setImageBitmap(data[position].cityImage)
        }

    }

    override fun getItemCount(): Int {
        return  if(data.isNotEmpty())  data.size else 0
    }

    fun setDataAdapter(data:List<City>) {
        this.data = data
        notifyDataSetChanged()
    }
}