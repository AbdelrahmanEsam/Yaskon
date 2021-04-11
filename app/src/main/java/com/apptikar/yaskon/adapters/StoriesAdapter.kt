package com.apptikar.yaskon.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.apptikar.yaskon.R
import com.apptikar.yaskon.pojos.City
import com.apptikar.yaskon.pojos.StoryHome
import java.util.ArrayList

class StoriesAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
          R.layout.add_story
        }else {
            R.layout.stories
        }
    }
    var data: List<StoryHome> = ArrayList()
    class StoriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var  storyNameTextView : TextView = itemView.findViewById(R.id.storyName)
        var  storyImage : ImageView = itemView.findViewById(R.id.story_image)
    }

    class AddStoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var  storyNameTextView : TextView = itemView.findViewById(R.id.storyName_profile)
        var  storyImage : ImageView = itemView.findViewById(R.id.profile_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
       lateinit var view :View
           if (viewType == R.layout.add_story) {
            view =LayoutInflater.from(parent.context).inflate(R.layout.add_story, parent, false)
            return AddStoryViewHolder(view)
        }else {
          view =  LayoutInflater.from(parent.context).inflate(R.layout.stories, parent, false)
               return  StoriesViewHolder(view)
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
}