package com.example.rickandmortynew.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.domain.models.character.SimpleLocation
import com.example.rickandmortynew.R
import com.example.rickandmortynew.databinding.ItemCharacterBinding
import com.example.rickandmortynew.presentation.base.BaseDiffUtilCallback
import com.example.rickandmortynew.presentation.ui.enums.CharacterStatus
import com.example.rickandmortynew.presentation.models.CharacterUI

class CharacterPagingAdapter(
    val onItemClick: (name: String, id: Int) -> Unit,
    val onItemLongClick: (image: String) -> Unit,
) : PagingDataAdapter<CharacterUI, CharacterPagingAdapter.CharacterViewHolder>(
    BaseDiffUtilCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(
            ItemCharacterBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    inner class CharacterViewHolder(
        private val binding: ItemCharacterBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            with(binding) {

                root.setOnClickListener {
                    with(getItem(absoluteAdapterPosition)!!) {
                        onItemClick(name, id)
                    }
                }

                root.setOnLongClickListener {
                    onItemLongClick(getItem(absoluteAdapterPosition)!!.image)
                    true
                }
            }
        }

        fun onBind(character: CharacterUI) = with(binding) {
            imageItemCharacter.load(character.image)
            tvName.text = character.name
            setupCharacterStatus(character.status)
            textItemCharacterStatusAndSpecies.text = textItemCharacterStatusAndSpecies
                .context
                .resources
                .getString(
                    R.string.hyphen, character.status, character.species
                )
            with(textItemCharacterLastKnownLocationData) {
                text = character.location.name
                isEnabled = character.location.url.isNotEmpty()
            }
        }

        private fun setupCharacterStatus(status: String) = with(binding) {
            when (status) {
                CharacterStatus.ALIVE.status -> {
                    imageItemCharacterStatus.setImageResource(CharacterStatus.ALIVE.image)
                }
                CharacterStatus.DEAD.status -> {
                    imageItemCharacterStatus.setImageResource(CharacterStatus.DEAD.image)
                }
                CharacterStatus.UNKNOWN.status -> {
                    imageItemCharacterStatus.setImageResource(CharacterStatus.UNKNOWN.image)
                }
            }
        }
    }
}