package com.example.rickandmortynew.presentation.ui.fragments.location

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmortynew.R
import com.example.rickandmortynew.databinding.FragmentLocationsBinding
import com.example.rickandmortynew.presentation.activity.MainActivity
import com.example.rickandmortynew.presentation.adapters.LocationAdapter
import com.example.rickandmortynew.presentation.adapters.paging.LoadStateAdapter
import com.example.rickandmortynew.presentation.base.BaseFragment
import com.example.rickandmortynew.presentation.extensions.bindUIToLoadState
import com.example.rickandmortynew.presentation.ui.fragments.location.detail.LocationsFragmentDirections
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class LocationsFragment :
BaseFragment<LocationsViewModel, FragmentLocationsBinding>(
    R.layout.fragment_locations
) {

    override val binding by viewBinding(FragmentLocationsBinding::bind)
    override val viewModel: LocationsViewModel by viewModels()

    private val locationAdapter = LocationAdapter(this::onItemClick)

    override fun initialize() = with(binding) {
        recyclerLocations.apply {
            adapter = locationAdapter.withLoadStateFooter(
                footer = LoadStateAdapter { locationAdapter.retry() }
            )
            layoutManager = LinearLayoutManager(context)
        }

        locationAdapter.bindUIToLoadState(recyclerLocations, progressLocationsLoader) {
        }
    }

    override fun setupListeners() {
        (requireActivity() as MainActivity).setOnBottomNavigationItemReselectListener {
            binding.recyclerLocations.smoothScrollToPosition(0)
        }
    }

    private fun onItemClick(name: String, id: Int) {
        findNavController().navigate(
            LocationsFragmentDirections.actionNavigationLocationsToLocationDetailFragment(
                label = "${getString(R.string.fragment_label_detail_location)} $name",
                id = id
            )
        )
    }

    override fun setupSubscribers() {
        lifecycleScope.launch {
            viewModel.fetchLocations().collectLatest {
                locationAdapter.submitData(it)
            }
        }
    }
}


