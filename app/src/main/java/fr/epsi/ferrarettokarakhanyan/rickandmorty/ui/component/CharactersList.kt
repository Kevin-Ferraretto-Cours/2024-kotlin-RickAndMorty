package fr.epsi.ferrarettokarakhanyan.rickandmorty.ui.component

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import fr.epsi.ferrarettokarakhanyan.rickandmorty.data.network.model.Character
import fr.epsi.ferrarettokarakhanyan.rickandmorty.ui.theme.RickAndMortyTheme

@Composable
fun CharactersList(modifier : Modifier = Modifier,list : List<Character>) {
	LazyColumn(modifier = modifier) {
		items(list) { item ->
			CharactersItemList(
				imageUrl = "",characterName = item.name
			)
		}
	}
}

@Preview
@Composable
private fun CharactersListPreview() {
	RickAndMortyTheme {
		// Création de quelques objets Character
		val character1 = Character(
			name = "John Doe",
			id = 1,
		)

		val character2 = Character(
			name = "Jane Smith",
			id = 2,
		)

		// Création d'une liste contenant ces personnages
		val charactersList : List<Character> = listOf(character1,character2)
		CharactersList(list = charactersList)
	}
}