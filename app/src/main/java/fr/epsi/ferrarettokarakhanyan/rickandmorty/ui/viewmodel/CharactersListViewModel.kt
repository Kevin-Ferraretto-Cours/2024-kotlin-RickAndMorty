package fr.epsi.ferrarettokarakhanyan.rickandmorty.ui.viewmodel

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.epsi.ferrarettokarakhanyan.rickandmorty.data.network.RickAndMortyApiService
import fr.epsi.ferrarettokarakhanyan.rickandmorty.data.network.model.Character
import fr.epsi.ferrarettokarakhanyan.rickandmorty.data.network.model.CharacterResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CharactersListViewModel : ViewModel() {
	init {
		getCharacters()
	}

	data class UiState(
		var characterResult : CharacterResult = CharacterResult(),
		var characters : List<Character> = ArrayList(),
		var failed : Boolean = false
	)

	// Expose screen UI state
	private val _charactersData = MutableStateFlow(UiState())
	val charactersData : StateFlow<UiState> = _charactersData.asStateFlow()

	private fun updateState(update : UiState.() -> UiState) {
		_charactersData.value = _charactersData.value.update()
	}

	// Handle business logic
	private fun getCharacters(page : Int = 1) {
		viewModelScope.launch {
			val listCharactersResult = RickAndMortyApiService.service.getAllCharacter(page)
			RickAndMortyApiService.executeApiCall(listCharactersResult,onSuccess = { response ->
				response.body()?.let { charactersResult ->
					updateState {
						copy(
							characterResult = charactersResult,
							characters = characters + (charactersResult.results ?: emptyList())
						)
					}
					charactersResult.results?.forEach { _ ->
						updateState {
							val characterOrder = characters.sortedBy { it.id }
							copy(characters = characterOrder)
						}
					}
				}
			},onFailure = {
				updateState {
					copy(
						failed = true
					)
				}
			})
		}
	}

	fun addCharacterToList() {
		viewModelScope.launch {
			val urlString = charactersData.value.characterResult.info?.next ?: return@launch
			val uri = Uri.parse(urlString)
			val page = uri.getQueryParameter("page")?.toIntOrNull() ?: 0
			getCharacters(page)
		}
	}
}