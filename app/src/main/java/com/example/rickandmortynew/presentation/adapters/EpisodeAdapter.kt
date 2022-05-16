package com.example.rickandmortynew.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortynew.databinding.ItemEpisodeBinding
import com.example.rickandmortynew.presentation.base.BaseDiffUtilCallback
import com.example.rickandmortynew.presentation.models.EpisodeUI

class EpisodeAdapter(
    val onItemClick: (name: String, id: Int) -> Unit
) : PagingDataAdapter<EpisodeUI, EpisodeAdapter.EpisodeViewHolder>(
    BaseDiffUtilCallback()
) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EpisodeAdapter.EpisodeViewHolder {
        return EpisodeViewHolder(
            ItemEpisodeBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: EpisodeAdapter.EpisodeViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    inner class EpisodeViewHolder(
        private val binding: ItemEpisodeBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                getItem(absoluteAdapterPosition)!!.apply {
                    onItemClick(name, id)
                }
            }
        }

        fun onBind(episodeUI: EpisodeUI) = with(binding) {
            textItemEpisodeName.text = episodeUI.name
            textItemEpisodeCodeOfEpisode.text = episodeUI.episode
            textItemEpisodeAirDate.text = episodeUI.airDate
        }
    }
}