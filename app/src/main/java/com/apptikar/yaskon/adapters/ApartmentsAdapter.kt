package com.apptikar.yaskon.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.apptikar.yaskon.R
import com.apptikar.yaskon.pojos.Apartments
import com.apptikar.yaskon.pojos.City
import java.util.ArrayList


class ApartmentsAdapter : RecyclerView.Adapter<ApartmentsAdapter.ViewHolder>() {
        var data: List<Apartments> = ArrayList()
        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
        {
            val  apartmentTextView : TextView = itemView.findViewById(R.id.apartment_name)
            val  apartmentImage : ImageView = itemView.findViewById(R.id.apartment_image)
            val  apartmentOverView : TextView = itemView.findViewById(R.id.apartment_overview)
            val  priceTextView : TextView = itemView.findViewById(R.id.price_text)
            val  bedsNumber: TextView = itemView.findViewById(R.id.beds_number)
            val  bathsNumber: TextView = itemView.findViewById(R.id.baths_number)
            val  squareSize: TextView = itemView.findViewById(R.id.square_size)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.apartment_templete, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val apartment = data[position]
            holder.apply {
                apartmentTextView.text = apartment.apartmentName
                apartmentImage.setImageBitmap(apartment.apartmentImage)
                apartmentOverView.text = apartment.apartmentOverView
                priceTextView.text = apartment.price
                bedsNumber.text = apartment.bedsNum
                bathsNumber.text = apartment.bathsNum
                squareSize.text = apartment.squareSize
            }

        }

        override fun getItemCount(): Int {
            return  if(data.isNotEmpty())  data.size else 0
        }

        fun setDataAdapter(data:List<Apartments>) {
            this.data = data
            notifyDataSetChanged()
        }


}