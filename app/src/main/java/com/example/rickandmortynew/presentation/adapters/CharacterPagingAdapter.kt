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
import com.example.rickandmortynew.presentation.ui.models.CharacterUI

class CharacterPagingAdapter(
    val onItemClick: (name: String, id: Int) -> Unit,
    val onItemLongClick: (image: String) -> Unit,
    val fetchFirstSeenIn: (position: Int, episodeUrl: String) -> Unit,
    val onItemLastKnownLocationClick: (location: SimpleLocation) -> Unit,
    val onItemFirstSeenOnClick: (name: String, url: String) -> Unit
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

    fun setFirstSeenIn(position: Int, firstSeenIn: String) {
        getItem(position)?.firstSeenIn = firstSeenIn
        notifyItemChanged(position)
    }

    inner class CharacterViewHolder(
        private val binding: ItemCharacterBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            with(binding) {

                root.setOnClickListener{
                    with(getItem(absoluteAdapterPosition)!!) {
                        onItemClick(name, id)
                    }
                }

                root.setOnClickListener{
                    onItemLongClick(getItem(absoluteAdapterPosition)!!.image)
                    true
                }

                textItemCharacterLastKnownLocationData.setOnClickListener {
                    onItemLastKnownLocationClick(getItem(absoluteAdapterPosition)!!.location)
                }

                textItemCharacterFirstSeenInData.setOnClickListener {
                    with(getItem(absoluteAdapterPosition)!!) {
                        onItemFirstSeenOnClick(firstSeenIn, episode.first())
                    }
                }
            }
        }

        fun onBind(characterUI: CharacterUI) = with(binding) {
            imageItemCharacter.load(characterUI.image)
            tvName.text = characterUI.name
            setupCharacterStatus(characterUI.status)
            textItemCharacterStatusAndSpecies.text = textItemCharacterStatusAndSpecies
                .context
                .resources
                .getString(
                    R.string.hyphen, characterUI.status, characterUI.species
                )
            with(textItemCharacterLastKnownLocationData) {
                text = characterUI.location.name
                isEnabled = characterUI.location.url.isNotEmpty()
            }
            setupFirstSeenIn(characterUI.firstSeenIn, characterUI.episode.first())
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

        private fun setupFirstSeenIn(firstSeenIn: String, episode: String) = with(binding) {
            progressBarCharacterFirstSeenIn.isVisible = firstSeenIn.isEmpty()
            textItemCharacterFirstSeenInData.isVisible = firstSeenIn.isNotEmpty()
            if (firstSeenIn.isEmpty()) {
                fetchFirstSeenIn(absoluteAdapterPosition,episode)
            } else {
                textItemCharacterFirstSeenInData.text = firstSeenIn
            }
        }
    }
}