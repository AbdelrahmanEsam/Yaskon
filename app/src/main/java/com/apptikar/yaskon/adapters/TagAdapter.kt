package com.apptikar.yaskon.adapters

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.apptikar.yaskon.R
import com.apptikar.yaskon.pojos.Tag
import de.hdodenhof.circleimageview.CircleImageView
import java.util.ArrayList

class TagAdapter(var context: Context,private val listener :OnTagListener): RecyclerView.Adapter<TagAdapter.ViewHolder>() {
    var data: List<Tag> = ArrayList()
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),View.OnClickListener
    {
        init {
        itemView.setOnClickListener(this)
    }
     var tag:TextView =  itemView.findViewById(R.id.tagText)
        override fun onClick(p0: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onTagClicked(tag,position)
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.type_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.apply {
         holder.tag.text = data[position].tag
            if (data[position].selected){
                tag.background = ContextCompat.getDrawable(context, R.drawable.background_type_orange)
                tag.setTextColor(Color.WHITE)

            }else
            {
                tag.background = ContextCompat.getDrawable(context, R.drawable.background_type_border)
                tag.setTextColor(Color.BLACK)
            }

        }

    }

    override fun getItemCount(): Int {
        return  if(data.isNotEmpty())  data.size else 0
    }

    fun setDataAdapter(data:List<Tag>) {
        this.data = data
        notifyDataSetChanged()
    }


    interface OnTagListener
    {
        fun onTagClicked(tag:TextView, position: Int)
    }


}