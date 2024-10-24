package fr.epsi.ferrarettokarakhanyan.rickandmorty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import fr.epsi.ferrarettokarakhanyan.rickandmorty.ui.theme.Purple
import fr.epsi.ferrarettokarakhanyan.rickandmorty.ui.theme.RickAndMortyTheme

class CharactersListActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState : Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
			RickAndMortyTheme {
				Scaffold(
					topBar = { TopBarCharactersList() },modifier = Modifier.fillMaxSize()
				) { innerPadding ->
					Greeting(
						name = "Android",modifier = Modifier.padding(innerPadding)
					)
				}
			}
		}
	}
}

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

@Composable
fun Greeting(name : String,modifier : Modifier = Modifier) {
	Text(
		text = "Hello $name!",modifier = modifier
	)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
	RickAndMortyTheme {
		Greeting("Android")
	}
}