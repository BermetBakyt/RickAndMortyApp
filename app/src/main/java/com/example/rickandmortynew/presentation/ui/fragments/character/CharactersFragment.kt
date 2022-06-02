package com.example.rickandmortynew.presentation.ui.fragments.character

import android.net.Uri
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.domain.Either
import com.example.domain.models.character.SimpleLocation
import com.example.rickandmortynew.R
import com.example.rickandmortynew.databinding.FragmentCharacterPagingBinding
import com.example.rickandmortynew.presentation.activity.MainActivity
import com.example.rickandmortynew.presentation.adapters.CharacterPagingAdapter
import com.example.rickandmortynew.presentation.adapters.paging.LoadStateAdapter
import com.example.rickandmortynew.presentation.base.BaseFragment
import com.example.rickandmortynew.presentation.extensions.bindUIToLoadState
import com.example.rickandmortynew.presentation.extensions.showToastShort
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharactersFragment : BaseFragment<CharacterPagingViewModel, FragmentCharacterPagingBinding>(
    R.layout.fragment_character_paging
) {

    override val viewModel by viewModel<CharacterPagingViewModel>()
    override val binding by viewBinding(FragmentCharacterPagingBinding::bind)

    private val characterAdapter = CharacterPagingAdapter(
        this::onItemClick,
        this::onItemLongClick,
    )

    override fun initialize() {
        setupPagingRecycler()
    }

    private fun setupPagingRecycler() = with(binding) {
        with(recyclerCharacters) {
            layoutManager = LinearLayoutManager(context)
            adapter = characterAdapter.withLoadStateFooter(
                footer = LoadStateAdapter { characterAdapter.retry() }
            )
        }

        characterAdapter.addLoadStateListener { loadStates ->
            recyclerCharacters.isVisible = loadStates.refresh is LoadState.NotLoading
            progressCharactersLoader.isVisible = loadStates.refresh is LoadState.Loading
        }
    }

    override fun setupRequests() {
        fetchFooPaging()
    }

    private fun fetchFooPaging() {
        viewModel.fetchCharactersPaging().collectPaging {
            characterAdapter.submitData(it)
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
}