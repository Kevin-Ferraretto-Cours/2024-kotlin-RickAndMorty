package fr.epsi.ferrarettokarakhanyan.rickandmorty.ui.component

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import fr.epsi.ferrarettokarakhanyan.rickandmorty.ui.theme.RickAndMortyTheme

@Composable
fun CharactersList(modifier : Modifier = Modifier) {
	LazyColumn(modifier = modifier) {
		items(5) { index ->
			Text(text = "Item: $index")
		}
	}
}

@Preview
@Composable
private fun CharactersListPreview() {
	RickAndMortyTheme {
		CharactersList()
	}
}