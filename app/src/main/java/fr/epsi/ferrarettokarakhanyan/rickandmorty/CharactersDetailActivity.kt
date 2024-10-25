package fr.epsi.ferrarettokarakhanyan.rickandmorty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import fr.epsi.ferrarettokarakhanyan.rickandmorty.ui.component.topbar.TopBarCharactersDetail
import fr.epsi.ferrarettokarakhanyan.rickandmorty.ui.theme.RickAndMortyTheme
import fr.epsi.ferrarettokarakhanyan.rickandmorty.ui.viewmodel.CharactersDetailViewModel

class CharactersDetailActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState : Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
//			val character = intent.getParcelableExtra<Character>("character")
			RickAndMortyTheme {
				val charactersDetailViewModel : CharactersDetailViewModel = viewModel()
				Scaffold(
					topBar = {
						TopBarCharactersDetail(
							name = charactersDetailViewModel.character.name
						) {
							finish()
						}

					},modifier = Modifier.fillMaxSize()
				) { innerPadding ->
					Text(
						text = "test",modifier = Modifier.padding(innerPadding)
					)
				}
			}
		}
	}
}