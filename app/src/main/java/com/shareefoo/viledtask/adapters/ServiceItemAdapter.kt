package com.shareefoo.viledtask.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shareefoo.viledtask.data.model.Category
import com.shareefoo.viledtask.databinding.ItemServiceBinding
import com.shareefoo.viledtask.data.model.Service
import com.shareefoo.viledtask.ui.main.MainFragmentDirections

class ServiceItemAdapter(
    private var services: List<Service>,
    private var categories: List<Category>
) :
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
                    // navigate to details fragment and pass selected service id
                    val humanizedId = this.humanizedId
                    val action =
                        MainFragmentDirections.actionMainFragmentToDetailsFragment(humanizedId)
                    it.findNavController().navigate(action)
                }
            }
        }
    }

    // return the size of the list
    override fun getItemCount(): Int = services.size

    inner class ViewHolder(val binding: ItemServiceBinding) : RecyclerView.ViewHolder(binding.root)
}