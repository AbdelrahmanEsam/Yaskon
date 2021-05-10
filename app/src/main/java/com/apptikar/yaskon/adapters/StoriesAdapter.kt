package com.apptikar.yaskon.adapters

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.apptikar.yaskon.R
import com.apptikar.yaskon.R.id
import com.apptikar.yaskon.pojos.StoryHome
import de.hdodenhof.circleimageview.CircleImageView
import java.util.ArrayList

class StoriesAdapter(private val listener :OnStoryListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
          R.layout.add_story
        }else {
            R.layout.stories
        }
    }
    var data: List<StoryHome> = ArrayList()
   inner class StoriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),View.OnClickListener
    {
        init {
            itemView.setOnClickListener(this)
        }
        val  storyNameTextView : TextView = itemView.findViewById(id.storyName)
        val  storyImage : CircleImageView = itemView.findViewById(id.profile_image_comment)
         val  borderImage : CircleImageView = itemView.findViewById(id.border)

        override fun onClick(p0: View?) {
            val position = adapterPosition
            storyImage.transitionName = "story$adapterPosition"
            if (position != RecyclerView.NO_POSITION) {
                listener.onStoryClicked(borderImage,storyImage,position)
            }
        }

    }

    class AddStoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var  storyNameTextView : TextView = itemView.findViewById(id.storyName_profile)
        var  storyImage : ImageView = itemView.findViewById(id.profile_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
       lateinit var view :View
        return if (viewType == R.layout.add_story) {
            view =LayoutInflater.from(parent.context).inflate(R.layout.add_story, parent, false)
            AddStoryViewHolder(view)
        }else {
            view =  LayoutInflater.from(parent.context).inflate(R.layout.stories, parent, false)
            StoriesViewHolder(view)
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (position == 0)
        {
            holder as AddStoryViewHolder
            holder.apply {
                storyNameTextView.text = data[position].StoryName
                storyImage.setImageBitmap(data[position].StoryImage)
            }
        }else
        {
            holder as StoriesViewHolder
            holder.apply {
                storyNameTextView.text = data[position].StoryName
                storyImage.setImageBitmap(data[position].StoryImage)
                if (data[position].seen){
                    borderImage.borderColor = Color.parseColor("#EDEFF2")

                }
            }
        }




    }

    override fun getItemCount(): Int {
        return  if(data.isNotEmpty())  data.size else 0
    }

    fun setDataAdapter(data:List<StoryHome>) {
        this.data = data
        notifyDataSetChanged()
    }



     interface OnStoryListener
    {
        fun onStoryClicked(border:CircleImageView,storyImage:CircleImageView, position: Int)
    }
}