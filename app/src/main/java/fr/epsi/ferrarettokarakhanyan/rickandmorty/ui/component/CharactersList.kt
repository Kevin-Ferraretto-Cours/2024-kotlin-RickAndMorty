package fr.epsi.ferrarettokarakhanyan.rickandmorty.ui.component

import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import fr.epsi.ferrarettokarakhanyan.rickandmorty.ui.viewmodel.CharactersListViewModel

@Composable
fun CharactersList(
	modifier : Modifier = Modifier,charactersListViewModel : CharactersListViewModel
) {
	val agentsData by charactersListViewModel.charactersData.collectAsState()
	LazyColumn(modifier = modifier) {
		Log.d("CharactersList",agentsData.characters.size.toString())
		items(count = agentsData.characters.size) { index ->
			CharactersItemList(
				imageUrl = agentsData.characters[index].image,
				characterName = agentsData.characters[index].name
			)
		}
	}
}