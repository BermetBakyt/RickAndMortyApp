package com.example.rickandmortynew.presentation.ui.fragments.episodes

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.alis.rickandmorty.presentation.ui.fragments.episodes.EpisodesFragmentDirections
import com.example.rickandmortynew.R
import com.example.rickandmortynew.databinding.FragmentEpisodesBinding
import com.example.rickandmortynew.databinding.FragmentLocationsBinding
import com.example.rickandmortynew.presentation.activity.MainActivity
import com.example.rickandmortynew.presentation.adapters.EpisodeAdapter
import com.example.rickandmortynew.presentation.adapters.LocationAdapter
import com.example.rickandmortynew.presentation.adapters.paging.LoadStateAdapter
import com.example.rickandmortynew.presentation.base.BaseFragment
import com.example.rickandmortynew.presentation.extensions.bindUIToLoadState
import com.example.rickandmortynew.presentation.ui.fragments.location.LocationsViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class EpisodesFragment : BaseFragment<EpisodesViewModel, FragmentEpisodesBinding>(
    R.layout.fragment_episodes
) {

    override val binding by viewBinding(FragmentEpisodesBinding::bind)
    override val viewModel by viewModel<EpisodesViewModel>()

    private val episodeAdapter = EpisodeAdapter(this::onItemClick)

    override fun initialize() = with(binding) {
        recyclerEpisodes.apply{
            adapter = episodeAdapter.withLoadStateFooter(
                footer = LoadStateAdapter { episodeAdapter.retry() }
            )
            layoutManager = LinearLayoutManager(context)
        }

        episodeAdapter.bindUIToLoadState(recyclerEpisodes, progressEpisodesLoader) {
        }
    }

    override fun setupListeners() {
        (requireActivity() as MainActivity).setOnBottomNavigationItemReselectListener{
            binding.recyclerEpisodes.smoothScrollToPosition(0)
        }
    }

    private fun onItemClick(name: String, id: Int) {
        findNavController().navigate(
            EpisodesFragmentDirections.actionNavigationEpisodesToEpisodeDetailFragment(
                label = "${getString(R.string.fragment_label_detail_location)} $name",
                id = id
            )
        )
    }

    override fun setupSubscribers() {
        lifecycleScope.launch {
            viewModel.fetchEpisodes().collectLatest {
                episodeAdapter.submitData(it)
            }
        }
    }
}