package com.example.rickandmortynew.presentation.ui.fragments.episodes.detail

import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmortynew.R
import com.example.rickandmortynew.databinding.FragmentEpisodeDetailBinding
import com.example.rickandmortynew.presentation.base.BaseFragment
import com.example.rickandmortynew.presentation.extensions.showToastShort
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EpisodeDetailFragment(
) : BaseFragment<EpisodeDetailViewModel, FragmentEpisodeDetailBinding>(
    R.layout.fragment_episode_detail
) {

    override val viewModel: EpisodeDetailViewModel by activityViewModels()
    override val binding by viewBinding(FragmentEpisodeDetailBinding::bind)
    private val args: EpisodeDetailFragmentArgs by navArgs()

    override fun setupRequests() {
        viewModel.fetchEpisodeDetail(args.id)
    }

    override fun setupObservers() {
        subscribeToEpisodesState()
    }

    private fun subscribeToEpisodesState() = with(binding) {
        viewModel.episodeDetailState.collectUIState(
            allStates = {
                it.setupViewVisibility(groupEpisodeDetail, loaderEpisode)
            },
            onError = {
                showToastShort(it)
            },
            onSuccess = {
                tvName.text = it.name
                tvAirDate.text = it.airDate
                tvEpisode.text = it.episode
                tvCreated.text = it.created
                tvUrl.text = it.url
                tvCharacters.text = it.characters.toString()
            }
        )
    }
}


