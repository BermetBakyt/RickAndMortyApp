package com.example.rickandmortynew.presentation.ui.extensions

import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.paging.CombinedLoadStates
import androidx.paging.LoadState
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView

fun <T : Any, VH : RecyclerView.ViewHolder> PagingDataAdapter<T, VH>.bindUIToLoadState(
    recyclerView: RecyclerView,
    progressBar: ProgressBar,
    listener: (CombinedLoadStates) -> Unit
) {
    addLoadStateListener { loadStates ->
        recyclerView.isVisible = loadStates.refresh is LoadState.NotLoading
        progressBar.isVisible = loadStates.refresh is LoadState.Loading
        listener(loadStates)
    }
}