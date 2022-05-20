package com.example.rickandmortynew.presentation.ui.fragments.character

import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmortynew.R
import com.example.rickandmortynew.databinding.FragmentCharacterPagingBinding
import com.example.rickandmortynew.presentation.activity.MainActivity
import com.example.rickandmortynew.presentation.adapters.CharacterPagingAdapter
import com.example.rickandmortynew.presentation.adapters.paging.LoadStateAdapter
import com.example.rickandmortynew.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharactersFragment : BaseFragment<CharactersViewModel, FragmentCharacterPagingBinding>(
    R.layout.fragment_character_paging
) {

    override val viewModel: CharactersViewModel by activityViewModels()
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