package com.example.rickandmortynew.presentation.ui.fragments.location.detail

import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmortynew.R
import com.example.rickandmortynew.databinding.FragmentLocationDetailBinding
import com.example.rickandmortynew.presentation.base.BaseFragment
import com.example.rickandmortynew.presentation.extensions.showToastShort
import org.koin.androidx.viewmodel.ext.android.viewModel

class LocationDetailFragment() : BaseFragment<LocationDetailViewModel, FragmentLocationDetailBinding>(
    R.layout.fragment_location_detail
) {

    override val viewModel by viewModel<LocationDetailViewModel>()
    override val binding by viewBinding(FragmentLocationDetailBinding::bind)
    private val args: LocationDetailFragmentArgs by navArgs()

    override fun setupRequests() {
        viewModel.fetchLocationDetail(args.id)
    }

    override fun setupSubscribers() {
        subscribeToEpisodesState()
    }

    private fun subscribeToEpisodesState() = with(binding) {
        viewModel.episodeDetailState.collectUIState(
            state = {
                it.setupViewVisibility(groupLocationDetail, loaderLocation)
            },
            onError = {
                showToastShort(it)
            },
            onSuccess = {
                tvName.text = it.name
                tvDimension.text = it.dimension
                tvType.text = it.type
                tvCreated.text = it.created
                tvUrl.text = it.url
                tvResidents.text = it.residents.toString()
            }
        )
    }
}