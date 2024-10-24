package fr.epsi.ferrarettokarakhanyan.rickandmorty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import fr.epsi.ferrarettokarakhanyan.rickandmorty.data.network.model.Character
import fr.epsi.ferrarettokarakhanyan.rickandmorty.ui.component.CharactersList
import fr.epsi.ferrarettokarakhanyan.rickandmorty.ui.component.topbar.TopBarCharactersList
import fr.epsi.ferrarettokarakhanyan.rickandmorty.ui.theme.RickAndMortyTheme

class CharactersListActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState : Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
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
				Scaffold(
					topBar = { TopBarCharactersList() },modifier = Modifier.fillMaxSize()
				) { innerPadding ->
					CharactersList(
						modifier = Modifier.padding(innerPadding),list = charactersList
					)

				}
			}
		}
	}
}