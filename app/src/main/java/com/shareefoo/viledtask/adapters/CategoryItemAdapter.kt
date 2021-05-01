package com.shareefoo.viledtask.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shareefoo.viledtask.R
import com.shareefoo.viledtask.models.Category

class CategoryItemAdapter constructor(private var categories: List<Category>) :
    RecyclerView.Adapter<CategoryItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category: Category = categories[position]

        holder.categoryTitle.text = category.title

        //
        Glide.with(holder.itemView)
            .load(category.iconUrl)
            .into(holder.categoryThumbnail)
    }

    override fun getItemCount(): Int = categories.size

    inner class ViewHolder(RequestView: View) : RecyclerView.ViewHolder(RequestView) {
        val categoryThumbnail: ImageView = RequestView.findViewById(R.id.category_thumbnail)
        val categoryTitle: TextView = RequestView.findViewById(R.id.category_title)
    }

}