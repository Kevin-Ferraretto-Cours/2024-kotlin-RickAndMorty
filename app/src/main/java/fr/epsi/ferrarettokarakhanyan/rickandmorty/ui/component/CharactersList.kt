package fr.epsi.ferrarettokarakhanyan.rickandmorty.ui.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import fr.epsi.ferrarettokarakhanyan.rickandmorty.ui.viewmodel.CharactersDetailViewModel
import fr.epsi.ferrarettokarakhanyan.rickandmorty.ui.viewmodel.CharactersListViewModel

@Composable
fun CharactersList(
	modifier : Modifier = Modifier,
	charactersListViewModel : CharactersListViewModel,
	charactersDetailViewModel : CharactersDetailViewModel,
	navController : NavController
) {
	val agentsData by charactersListViewModel.charactersData.collectAsState()
	LazyColumn(modifier = modifier.padding(8.dp)) {
		items(count = agentsData.characters.size) { index ->
			CharactersItemList(
				character = agentsData.characters[index],
				charactersDetailViewModel = charactersDetailViewModel,
				navController = navController
			)

			if (index == (agentsData.characters.size - 5)) {
				LaunchedEffect(key1 = index) {
					charactersListViewModel.addCharacterToList()
				}
			}
		}
	}
}