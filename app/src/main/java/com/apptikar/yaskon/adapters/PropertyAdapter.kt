package com.apptikar.yaskon.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.apptikar.yaskon.R
import com.apptikar.yaskon.pojos.Apartments
import de.hdodenhof.circleimageview.CircleImageView
import java.util.*


class PropertyAdapter(private val listener : OnPropertyListener) : RecyclerView.Adapter<PropertyAdapter.ViewHolder>() {
      private  var data: List<Apartments> = ArrayList()
      private lateinit var type:String
      inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),View.OnClickListener
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
                    listener.onPropertyClicked(apartmentImage,position)
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

            val view = if (type == "result") {
                LayoutInflater.from(parent.context).inflate(
                    R.layout.result_apartment_templete,
                    parent,
                    false
                )
            }else {
                LayoutInflater.from(parent.context).inflate(
                    R.layout.apartment_templete,
                    parent,
                    false
                )
            }
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

        fun setDataAdapter(data: List<Apartments>, type: String) {
            this.data = data
            notifyDataSetChanged()
            this.type = type
        }

    interface OnPropertyListener
    {
        fun onPropertyClicked(apartmentImage : ImageView,position: Int)
    }
}