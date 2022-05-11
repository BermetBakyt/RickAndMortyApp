package com.example.rickandmortynew.presentation.ui.fragments.characterpaging

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmortynew.R
import com.example.rickandmortynew.databinding.FragmentCharacterPagingBinding
import com.example.rickandmortynew.presentation.adapters.CharacterPagingAdapter
import com.example.rickandmortynew.presentation.base.BaseFragment
import com.example.rickandmortynew.presentation.ui.extensions.bindUIToLoadState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CharacterPagingFragment : BaseFragment<CharacterPagingViewModel, FragmentCharacterPagingBinding>(
    R.layout.fragment_character_paging
) {

    override val binding by viewBinding(FragmentCharacterPagingBinding::bind)
    override val viewModel: CharacterPagingViewModel by viewModels()

    private val characterPagingAdapter = CharacterPagingAdapter(
        this::onItemClick,
        this::onItemLongClick,
        this::fetchFirstSeenIn,
        this::onItemLastKnowLocationClick,
        this::onItemFirstSeenOnClick,
    )

    override fun initialize() = with(binding) {
        recyclerCharacters.apply {
            adapter = characterPagingAdapter.withLoadStateFooter(
                footer = LoadStateAdapter { characterPagingAdapter.retry() }
            )
            layoutManager = LinearLayoutManager(context)
        }

        characterPagingAdapter.bindUIToLoadState(recyclerCharacters, progressCharactersLoader) {
        }
    }

    override fun onItemClick(name: String, id: Int) {
        findNavController().navigate(
            CharacterPagingFragmentDirections.actionListFragmentToDetailFragment(
                label = "${getString(R.string.fragment_label_detail_character)} $name",
                id = id
            )
        )
    }

    private fun onItemLongClick(image: String) {
        findNavController().navigate(
            CharacterPagingFragmentDirections.actionListFragmentToDetailFragment(
                image = image
            )
        )
    }

    private fun fetchFirstSeenIn(position: Int, episodeUrl: String) {
        lifecycleScope.launch {
            viewModel.()
        }
    }
}
