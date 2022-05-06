package com.example.rickandmortynew.presentation.ui.list

import com.example.domain.use_cases.FetchCharactersUseCase
import com.example.rickandmortynew.presentation.base.BaseViewModel
import com.example.rickandmortynew.presentation.ui.models.CharacterUI
import com.example.rickandmortynew.presentation.ui.models.toUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val fetchCharacterListUseCase: FetchCharactersUseCase
) : BaseViewModel() {

    private val _characterListState = MutableUIStateFlow<List<CharacterUI>>()
    val charactersState = _characterListState.asStateFlow()

    fun fetchCharacters() {
        fetchCharacterListUseCase().collectRequest(_characterListState) { data ->
            data.map {
                it.toUI() } }
    }
}