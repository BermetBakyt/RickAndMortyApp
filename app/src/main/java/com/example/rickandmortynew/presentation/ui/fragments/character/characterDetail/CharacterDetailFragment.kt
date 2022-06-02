package com.example.rickandmortynew.presentation.ui.fragments.character.characterDetail

import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import coil.load
import com.example.rickandmortynew.R
import com.example.rickandmortynew.databinding.FragmentCharacterDetailBinding
import com.example.rickandmortynew.presentation.base.BaseFragment
import com.example.rickandmortynew.presentation.extensions.showToastShort
import com.example.rickandmortynew.presentation.ui.fragments.detail.CharacterDetailViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterDetailFragment(
) : BaseFragment<CharacterDetailViewModel, FragmentCharacterDetailBinding>(
    R.layout.fragment_character_detail
) {

    override val binding by viewBinding(FragmentCharacterDetailBinding::bind)
    override val viewModel by viewModel<CharacterDetailViewModel>()
    private val args: CharacterDetailFragmentArgs by navArgs()

    override fun setupRequests() {
        viewModel.fetchCharacterDetail(args.id)
    }

    override fun setupSubscribers() {
        subscribeToCharactersState()
    }

    private fun subscribeToCharactersState() = with(binding) {
        viewModel.characterDetailState.collectUIState(
            state = {
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
                ivProfilePhoto.load(it.image)
            }
        )
    }
}
