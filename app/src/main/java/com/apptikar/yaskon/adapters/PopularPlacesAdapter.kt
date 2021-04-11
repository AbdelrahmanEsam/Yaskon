package com.apptikar.yaskon.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.apptikar.yaskon.R
import com.apptikar.yaskon.pojos.PopularPlaces
import java.util.ArrayList

class PopularPlacesAdapter : RecyclerView.Adapter<PopularPlacesAdapter.ViewHolder>() {
    var data: List<PopularPlaces> = ArrayList()
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var  cityNamePopularTextView : TextView = itemView.findViewById(R.id.cityNamePopular)
        var  placeNamePopularTextView : TextView = itemView.findViewById(R.id.placeNamePopular)
        var  placeImagePopularImageView : ImageView = itemView.findViewById(R.id.placeImagePopular)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.popular_places, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      holder.apply {
          cityNamePopularTextView.text = data[position].cityName
          placeNamePopularTextView.text = data[position].place
          placeImagePopularImageView.setImageBitmap(data[position].image)
      }

    }

    override fun getItemCount(): Int {
        return  if(data.isNotEmpty())  data.size else 0
    }

    fun setDataAdapter(data:List<PopularPlaces>) {
        this.data = data
        notifyDataSetChanged()
    }
}