package com.shareefoo.viledtask.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shareefoo.viledtask.databinding.ItemCategoryBinding
import com.shareefoo.viledtask.data.model.Category

class CategoryItemAdapter(private var categories: List<Category>) :
    RecyclerView.Adapter<CategoryItemAdapter.ViewHolder>() {

    // inflate the view of ItemCategoryBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCategoryBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    // bind the items with each item of the list
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(categories[position]) {
                //
                binding.tvCategoryTitle.text = this.title
                //
                Glide.with(itemView)
                    .load(this.iconUrl)
                    .into(binding.ivCategoryThumbnail)
            }
        }
    }

    // return the size of the list
    override fun getItemCount(): Int = categories.size

    inner class ViewHolder(val binding: ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root)
}