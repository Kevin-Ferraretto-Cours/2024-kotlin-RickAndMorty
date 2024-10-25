package fr.epsi.ferrarettokarakhanyan.rickandmorty.ui.component.topbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
fun TopBarCharactersDetail(
	name : String,onGoBack : () -> Unit
) {
	TopAppBar(navigationIcon = {
		IconButton(onClick = onGoBack) {
			Icon(
				imageVector = Icons.AutoMirrored.Filled.ArrowBack,
				contentDescription = "Back",
				tint = Color.LightGray
			)
		}
	},colors = topAppBarColors(
		containerColor = Purple,
		titleContentColor = Color.White,
	),title = {
		Text(text = name)
	})
}

@Preview
@Composable
fun TopBarCharactersDetailPreview() {
	RickAndMortyTheme {
		TopBarCharactersDetail(name = "Nom du personnage") {

		}
	}
}