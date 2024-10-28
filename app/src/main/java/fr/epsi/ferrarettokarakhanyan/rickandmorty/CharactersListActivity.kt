package fr.epsi.ferrarettokarakhanyan.rickandmorty

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import fr.epsi.ferrarettokarakhanyan.rickandmorty.ui.component.CharactersList
import fr.epsi.ferrarettokarakhanyan.rickandmorty.ui.component.topbar.TopBarCharactersDetail
import fr.epsi.ferrarettokarakhanyan.rickandmorty.ui.component.topbar.TopBarCharactersList
import fr.epsi.ferrarettokarakhanyan.rickandmorty.ui.navigation.Detail
import fr.epsi.ferrarettokarakhanyan.rickandmorty.ui.navigation.Home
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
				val navController = rememberNavController()
				val charactersListViewModel : CharactersListViewModel = viewModel()
				val charactersDetailViewModel : CharactersDetailViewModel = viewModel()
				NavHost(
					navController = navController,startDestination = Home.route
				) {
					composable(route = Home.route) {
						val agentsData by charactersListViewModel.charactersData.collectAsState()

						Scaffold(
							topBar = { TopBarCharactersList() },modifier = Modifier.fillMaxSize()
						) { innerPadding ->
							if (agentsData.failed) {
								Text(
									text = "Erreur de chargement des données",
									modifier = Modifier.padding(innerPadding)
								)
							} else {
								CharactersList(
									modifier = Modifier.padding(innerPadding),
									charactersListViewModel = charactersListViewModel,
									charactersDetailViewModel = charactersDetailViewModel,
									navController = navController
								)
							}
						}
					}

					composable(route = Detail.route) {
						Scaffold(
							topBar = {
								TopBarCharactersDetail(
									name = charactersDetailViewModel.character.name
								) {
									navController.popBackStack()
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
	}
}