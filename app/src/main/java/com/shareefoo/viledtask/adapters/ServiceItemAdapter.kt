package com.shareefoo.viledtask.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shareefoo.viledtask.R
import com.shareefoo.viledtask.databinding.ItemCategoryBinding
import com.shareefoo.viledtask.databinding.ItemServiceBinding
import com.shareefoo.viledtask.models.Service

class ServiceItemAdapter(private var services: List<Service>) :
    RecyclerView.Adapter<ServiceItemAdapter.ViewHolder>() {

    // inflate the view of ItemServiceBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemServiceBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    // bind the items with each item of the list
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(services[position]) {
                //
                binding.tvServiceTitle.text = this.title
                //
                Glide.with(itemView)
                    .load(this.iconUrl)
                    .into(binding.ivServiceThumbnail)

                itemView.setOnClickListener {
                    //
                }
            }
        }
    }

    // return the size of the list
    override fun getItemCount(): Int = services.size

    inner class ViewHolder(val binding: ItemServiceBinding) : RecyclerView.ViewHolder(binding.root)
}