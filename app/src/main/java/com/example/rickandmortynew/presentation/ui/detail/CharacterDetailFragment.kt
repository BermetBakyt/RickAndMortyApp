package com.example.rickandmortynew.presentation.ui.detail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.rickandmortynew.R
import com.example.rickandmortynew.databinding.DetailFragmentBinding
import com.example.rickandmortynew.presentation.base.BaseFragment
import com.example.rickandmortynew.presentation.ui.extensions.showToastShort
import com.example.rickandmortynew.presentation.ui.state.UIState

class CharacterDetailFragment : BaseFragment<CharacterDetailViewModel, DetailFragmentBinding>(R.layout.fragment_detail) {

    override val binding by viewBinding(DetailFragmentBinding::bind)
    override val viewModel: CharacterDetailViewModel by viewModels()
    private val args by navArgs<CharacterDetailFragmentArgs>()

    override fun setupRequests() {
        viewModel.fetchCharacterDetail(args.id)
    }

    override fun setupSubscribers() {
        subscribeToCharacterDetail()
    }

    override fun setupSubscribers() {
        subscribeToCharacterDetail()
    }

    private fun subscribeToCharacterDetail() = with(binding) {
        viewModel.characterDetailState.collectUIState {
            when (it) {
                is UIState.Idle -> {
                }
                is UIState.Loading -> {
                }
                is UIState.Error -> {
                    showToastShort(it.error)
                }
                is UIState.Success -> {
                    tvName.text = it.name
                    tvSpecies.text = it.data.species
                    tvStatus.text = it.data.status
                    tvGender.text = it.data.gender
                    tvLocation.text = it.data.location.toString()

                    tvDateCreated.text = it.data.created

                    Glide.with(binding.root)
                        .load(it.data.image)
                        .into(binding.ivProfilePhoto)
                }
            }
        }
    }
}



}