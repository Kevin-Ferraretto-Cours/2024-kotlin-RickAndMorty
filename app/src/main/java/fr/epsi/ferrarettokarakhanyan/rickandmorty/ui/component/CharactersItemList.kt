package fr.epsi.ferrarettokarakhanyan.rickandmorty.ui.component

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import fr.epsi.ferrarettokarakhanyan.rickandmorty.CharactersDetailActivity
import fr.epsi.ferrarettokarakhanyan.rickandmorty.data.network.model.Character
import fr.epsi.ferrarettokarakhanyan.rickandmorty.ui.viewmodel.CharactersDetailViewModel

@Composable
fun CharactersItemList(
	modifier : Modifier = Modifier,
	character : Character,
	charactersDetailViewModel : CharactersDetailViewModel
) {
	val context = LocalContext.current
	Card(onClick = {
		charactersDetailViewModel.setCharacter(character)
		val intent = Intent(context,CharactersDetailActivity::class.java)
//		intent.putExtra(name = "character",value = character as Parcelable)
		context.startActivity(intent)
	}) {
		Row(
			modifier = modifier
				.fillMaxWidth()
				.padding(16.dp),
			verticalAlignment = Alignment.CenterVertically
		) {
			AsyncImage(
				model = character.image,
				contentDescription = null,
				modifier = Modifier
					.size(64.dp)
					.clip(CircleShape)
					.background(Color.Gray)
			)
			Spacer(modifier = Modifier.width(16.dp))
			Text(
				text = character.name
			)
		}
	}

}

@Preview
@Composable
fun CharactersItemListPreview() {
	val character = Character(
		id = 0,name = "Nom du personnage",image = ""
	)
	val charactersDetailViewModel = CharactersDetailViewModel()
	CharactersItemList(
		character = character,charactersDetailViewModel = charactersDetailViewModel
	)
}
