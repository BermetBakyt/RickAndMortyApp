package com.example.rickandmortynew.presentation.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortynew.databinding.ItemRecyclerBinding
import com.example.rickandmortynew.presentation.base.BaseDiffUtilCallback
import com.example.rickandmortynew.presentation.ui.models.CharacterUI

class CharactersAdapter(
    private val action: (id: Int) -> Unit
) : ListAdapter<CharacterUI, CharactersAdapter.CharacterViewHolder>(BaseDiffUtilCallback()) {

    inner class CharacterViewHolder(
        private val binding: ItemRecyclerBinding
    ): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CharacterUI) {
            binding.apply {
                tvName.text = item.name
                tvSpecies.text = item.species
            }
            //coil.load(itemView.context).load(item.image).into(binding.ivProfilePhoto)
,
            itemView.setOnClickListener {
                action.invoke(item.id)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType:Int) : CharacterViewHolder {
        return CharacterViewHolder(ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}