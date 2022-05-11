package com.example.rickandmortynew.presentation.adapters.paging

import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter

class CommonLoadStateAdapter(
    private val rerty: () -> Unit
) : LoadStateAdapter<CommonLoadStateViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState
    ): CommonLoadStateViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: CommonLoadStateViewHolder, loadState: LoadState) {
        TODO("Not yet implemented")
    }
}