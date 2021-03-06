package com.example.rickandmortynew.presentation.ui.fragments.detail

import com.example.domain.use_cases.FetchCharacterByIdUseCase
import com.example.rickandmortynew.presentation.base.BaseViewModel
import com.example.rickandmortynew.presentation.models.CharacterUI
import com.example.rickandmortynew.presentation.models.toCharacterUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel@Inject constructor(
    private val fetchCharacterByIdUseCase: FetchCharacterByIdUseCase
) : BaseViewModel() {

    private val _characterDetailState = MutableUIStateFlow<CharacterUI>()
    val characterDetailState = _characterDetailState.asStateFlow()

    fun fetchCharacterDetail(id: Int) {
        fetchCharacterByIdUseCase(id).collectRequest(_characterDetailState) { it.toCharacterUI() }
    }
}
