package com.example.coroutineexample.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coroutineexample.databinding.AdapterPostItemBinding
import com.example.coroutineexample.domain.model.PostDetails
import com.example.coroutineexample.domain.model.PostDetailsItem

class MainAdapter : RecyclerView.Adapter<MainViewHolder>() {

    var posts = mutableListOf<PostDetailsItem>()
    fun setPostLists(list:List<PostDetailsItem>){
        posts = list.toMutableList()
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterPostItemBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
         val posts = posts[position]
          holder.binding.textView2.text = posts.id.toString()
          holder.binding.textView3.text = posts.title
          holder.binding.textView4.text = posts.body
    }

    override fun getItemCount(): Int {
        return posts.size
    }
}

class MainViewHolder(val binding: AdapterPostItemBinding) : RecyclerView.ViewHolder(binding.root) {
}