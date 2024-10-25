package fr.epsi.ferrarettokarakhanyan.rickandmorty

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import fr.epsi.ferrarettokarakhanyan.rickandmorty.ui.component.CharactersList
import fr.epsi.ferrarettokarakhanyan.rickandmorty.ui.component.topbar.TopBarCharactersList
import fr.epsi.ferrarettokarakhanyan.rickandmorty.ui.theme.RickAndMortyTheme
import fr.epsi.ferrarettokarakhanyan.rickandmorty.ui.viewmodel.CharactersDetailViewModel
import fr.epsi.ferrarettokarakhanyan.rickandmorty.ui.viewmodel.CharactersListViewModel

class CharactersListActivity : ComponentActivity() {
	@SuppressLint("StateFlowValueCalledInComposition")
	override fun onCreate(savedInstanceState : Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
			RickAndMortyTheme {
				val charactersListViewModel : CharactersListViewModel = viewModel()
				val charactersDetailViewModel : CharactersDetailViewModel = viewModel()
				Scaffold(
					topBar = { TopBarCharactersList() },modifier = Modifier.fillMaxSize()
				) { innerPadding ->
					CharactersList(
						modifier = Modifier.padding(innerPadding),
						charactersListViewModel = charactersListViewModel,
						charactersDetailViewModel = charactersDetailViewModel
					)

				}
			}
		}
	}
}