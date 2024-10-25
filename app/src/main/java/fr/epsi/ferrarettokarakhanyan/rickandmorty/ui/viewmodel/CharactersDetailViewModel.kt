package fr.epsi.ferrarettokarakhanyan.rickandmorty.ui.viewmodel

import androidx.lifecycle.ViewModel
import fr.epsi.ferrarettokarakhanyan.rickandmorty.data.network.model.Character

class CharactersDetailViewModel : ViewModel() {

	var character : Character = Character()
		private set

	fun setCharacter(newCharacter : Character) {
		character = newCharacter
	}
}