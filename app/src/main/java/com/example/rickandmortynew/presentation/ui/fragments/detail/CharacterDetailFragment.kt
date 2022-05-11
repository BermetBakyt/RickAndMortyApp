package com.example.rickandmortynew.presentation.ui.fragments.detail

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.rickandmortynew.R
import com.example.rickandmortynew.databinding.FragmentDetailBinding
import com.example.rickandmortynew.presentation.base.BaseFragment
import com.example.rickandmortynew.presentation.ui.extensions.showToastShort
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterDetailFragment(
) : BaseFragment<CharacterDetailViewModel, FragmentDetailBinding>(
    R.layout.fragment_detail
) {

    override val binding by viewBinding(FragmentDetailBinding::bind)
    override val viewModel: CharacterDetailViewModel by viewModels()
    private val args: CharacterDetailFragmentArgs by navArgs()

    override fun setupRequests() {
        Log.e("message", "$id")
        viewModel.fetchCharacterDetail(args.id)
    }

    override fun setupSubscribers() {
        subscribeToCharactersState()
    }

    private fun subscribeToCharactersState() = with(binding) {
        viewModel.characterDetailState.collectUIState(
            allStates = {
                it.setupViewVisibility(groupCharacterDetail, loaderCharacter)
            },
            onError = {
                showToastShort(it)
            },
            onSuccess = {
                tvName.text = it.name
                tvSpecies.text = it.species
                tvStatus.text = it.status
                tvGender.text = it.gender
                tvDateCreated.text = it.created
                Glide.with(binding.root)
                    .load(it.image)
                    .into(binding.ivProfilePhoto)
            }
        )
    }
}
