package com.example.rickandmortynew.presentation.adapters

import android.location.Location
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortynew.databinding.FragmentLocationsBinding
import com.example.rickandmortynew.databinding.ItemLocationBinding
import com.example.rickandmortynew.presentation.base.BaseDiffUtilCallback
import com.example.rickandmortynew.presentation.models.LocationUI

class LocationAdapter(
    val onItemClick: (name: String, id: Int) -> Unit
) : PagingDataAdapter<LocationUI, LocationAdapter.LocationViewHolder>(
    BaseDiffUtilCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        return LocationViewHolder(
            ItemLocationBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it)}
    }

    inner class LocationViewHolder(
        private val binding: ItemLocationBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                getItem(absoluteAdapterPosition)!!.apply {
                    onItemClick(name, id)
                }
            }
        }

        fun onBind(location: LocationUI) = with(binding) {
            textItemLocationName.text = location.name
            textItemLocationType.text = location.type
            textItemLocationDimension.text = location.dimension
        }
    }
}