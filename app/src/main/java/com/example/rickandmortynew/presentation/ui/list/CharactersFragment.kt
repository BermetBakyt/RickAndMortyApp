package com.example.rickandmortynew.presentation.ui.list

import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmortynew.R
import com.example.rickandmortynew.databinding.FragmentListBinding
import com.example.rickandmortynew.presentation.base.BaseFragment
import com.example.rickandmortynew.presentation.ui.extensions.showToastShort
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharactersFragment : BaseFragment<CharactersViewModel, FragmentListBinding>(R.layout.fragment_list) {

    override val binding by viewBinding(FragmentListBinding::bind)
    override val viewModel: CharactersViewModel by viewModels()
    private lateinit var adapter: CharactersAdapter

    override fun initialize() {
        setupListAdapter()
    }

    private fun setupListAdapter() = with(binding.charactersRv) {
        layoutManager = LinearLayoutManager(context)
        adapter = CharactersAdapter { id ->
            findNavController().navigate(CharactersFragmentDirections.actionListFragmentToDetailFragment(id))
        }
        adapter = adapter
    }

    override fun setupRequests() {
        fetchCharacters()
    }

    private fun fetchCharacters() {
        viewModel.fetchCharacters()
    }

    override fun setupSubscribers() {
        subscribeToCharactersState()
    }

    private fun subscribeToCharactersState() = with(binding) {
        viewModel.charactersState.collectUIState(
            allStates = {
                it.setupViewVisibility(groupCharacter,loaderListCharacters)
            },
            onError = {
                showToastShort(it)
            },
            onSuccess = {
                adapter.submitList(it)
            }
        )
    }
}
