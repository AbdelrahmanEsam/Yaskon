package com.apptikar.yaskon.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.apptikar.yaskon.R
import com.apptikar.yaskon.pojos.Apartments
import java.util.ArrayList

class searchResultsAdapter(private val listener : OnResultsListener)  : RecyclerView.Adapter<searchResultsAdapter.ViewHolder>() {
    private  var data: List<Apartments> = ArrayList()
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener
    {

        init {
            itemView.setOnClickListener(this)
        }
        val  apartmentTextView : TextView = itemView.findViewById(R.id.apartment_name)
        val  apartmentImage : ImageView = itemView.findViewById(R.id.apartment_image)
        val  apartmentOverView : TextView = itemView.findViewById(R.id.apartment_overview)
        val  priceTextView : TextView = itemView.findViewById(R.id.price_text)
        val  bedsNumber: TextView = itemView.findViewById(R.id.beds_number)
        val  bathsNumber: TextView = itemView.findViewById(R.id.baths_number)
        val  squareSize: TextView = itemView.findViewById(R.id.square_size)
        override fun onClick(p0: View?) {
            val position = adapterPosition
            apartmentImage.transitionName = "story$adapterPosition"
            if (position != RecyclerView.NO_POSITION) {
                listener.onResultClicked(apartmentImage,position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.result_apartment_templete, parent,false)

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

    fun setDataAdapter(data: List<Apartments>) {
        this.data = data
        notifyDataSetChanged()
    }

    interface OnResultsListener
    {
        fun onResultClicked(apartmentImage : ImageView, position: Int)
    }
}
