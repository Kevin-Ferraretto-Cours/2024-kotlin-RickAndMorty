package fr.epsi.ferrarettokarakhanyan.rickandmorty.ui.component.topbar

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import fr.epsi.ferrarettokarakhanyan.rickandmorty.ui.theme.Purple
import fr.epsi.ferrarettokarakhanyan.rickandmorty.ui.theme.RickAndMortyTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarCharactersList() {
	TopAppBar(colors = topAppBarColors(
		containerColor = Purple,
		titleContentColor = Color.White,
	),title = {
		Text(text = "Rick and Morty")
	})
}

@Preview
@Composable
fun TopBarCharactersListPreview() {
	RickAndMortyTheme {
		TopBarCharactersList()
	}
}