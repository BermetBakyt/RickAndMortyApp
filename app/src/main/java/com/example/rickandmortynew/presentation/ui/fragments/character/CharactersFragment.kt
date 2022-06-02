package com.example.rickandmortynew.presentation.ui.fragments.character

import android.net.Uri
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.domain.Either
import com.example.domain.models.character.SimpleLocation
import com.example.rickandmortynew.R
import com.example.rickandmortynew.databinding.FragmentCharacterPagingBinding
import com.example.rickandmortynew.presentation.activity.MainActivity
import com.example.rickandmortynew.presentation.adapters.CharacterPagingAdapter
import com.example.rickandmortynew.presentation.base.BaseFragment
import com.example.rickandmortynew.presentation.extensions.bindUIToLoadState
import com.example.rickandmortynew.presentation.extensions.showToastShort
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharactersFragment :
    BaseFragment<CharacterPagingViewModel, FragmentCharacterPagingBinding>(
        R.layout.fragment_character_paging
    ) {

    override val binding by viewBinding(FragmentCharacterPagingBinding::bind)
    override val viewModel by viewModel<CharacterPagingViewModel>()

    private val characterPagingAdapter = CharacterPagingAdapter(
        this::onItemClick,
        this::onItemLongClick,
        this::onItemLastKnownLocationClick,
        this::onItemFirstSeenOnClick,
    )

    override fun initialize() = with(binding) {
        recyclerCharacters.apply {
            adapter = characterPagingAdapter.withLoadStateFooter(
                footer = com.example.rickandmortynew.presentation.adapters.paging.LoadStateAdapter { characterPagingAdapter.retry() }
            )
            layoutManager = LinearLayoutManager(context)
        }

        characterPagingAdapter.bindUIToLoadState(recyclerCharacters, progressCharactersLoader) {
        }
    }

    private fun onItemClick(name: String, id: Int) {
        findNavController().navigate(
            CharactersFragmentDirections.actionNavigationCharactersToCharacterDetailFragment(
                label = "${getString(R.string.fragment_label_detail_character)} $name",
                id = id
            )
        )
    }

    private fun onItemLongClick(image: String) {
        findNavController().navigate(
            CharactersFragmentDirections.actionNavigationCharactersToCharacterImageDialog(
                image = image
            )
        )
    }

    private fun onItemLastKnownLocationClick(location: SimpleLocation) {
        findNavController().navigate(
            CharactersFragmentDirections.actionNavigationCharactersToLocationDetailFragment(
                id = location.url.getIdFromUrl(),
                label = "${getString(R.string.fragment_label_detail_location)} ${location.name}"
            )
        )
    }

    private fun onItemFirstSeenOnClick(name: String, url: String) {
        findNavController().navigate(
            CharactersFragmentDirections.actionNavigationCharactersToEpisodeDetailFragment(
                label = "${getString(R.string.fragment_label_detail_episode)} $name",
                id = url.getIdFromUrl()
            )
        )
    }

    override fun setupSubscribers() {
        subscribeToCharacters()
    }

    private fun subscribeToCharacters() {
        lifecycleScope.launch {
            viewModel.fetchCharactersPaging().collectLatest {
                characterPagingAdapter.submitData(it)
            }
        }
    }

    private fun String.getIdFromUrl() = Uri.parse(this).lastPathSegment?.toInt()!!
}

