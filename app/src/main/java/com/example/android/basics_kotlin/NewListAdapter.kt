package com.example.android.basics_kotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class NewListAdapter(val items:ArrayList<String>,private val listener : NewsItemClicked): RecyclerView.Adapter<NewsViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
      val view = LayoutInflater.from(parent.context).inflate(R.layout.news_list,parent,false)
        val viewHolder = NewsViewHolder(view)
        view.setOnClickListener{
            listener.OnItemClicked(items[viewHolder.absoluteAdapterPosition])
        }
        return viewHolder

    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val currentItem = items[position]

        holder.titleView.text = currentItem
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

class NewsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    val titleView : TextView = itemView.findViewById(R.id.title);
}
interface NewsItemClicked{
    fun OnItemClicked(items: String)
}