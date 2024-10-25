package fr.epsi.ferrarettokarakhanyan.rickandmorty.ui.component

import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import fr.epsi.ferrarettokarakhanyan.rickandmorty.ui.viewmodel.CharactersDetailViewModel
import fr.epsi.ferrarettokarakhanyan.rickandmorty.ui.viewmodel.CharactersListViewModel

@Composable
fun CharactersList(
	modifier : Modifier = Modifier,
	charactersListViewModel : CharactersListViewModel,
	charactersDetailViewModel : CharactersDetailViewModel
) {
	val agentsData by charactersListViewModel.charactersData.collectAsState()
	LazyColumn(modifier = modifier) {
		Log.d("CharactersList",agentsData.characters.size.toString())
		items(count = agentsData.characters.size) { index ->
			CharactersItemList(
				character = agentsData.characters[index],
				charactersDetailViewModel = charactersDetailViewModel
			)

			if (index == (agentsData.characters.size - 5)) {
				LaunchedEffect(key1 = index) {
					charactersListViewModel.addCharacterToList()
				}
			}
		}
	}
}