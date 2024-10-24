package fr.epsi.ferrarettokarakhanyan.rickandmorty.ui.component

import androidx.compose.foundation.Image
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun CharactersItemList(
	modifier : Modifier = Modifier,imageUrl : String,characterName : String
) {
	Card(onClick = {

	}) {
		Row(
			modifier = modifier
                .fillMaxWidth()
                .padding(16.dp),
			verticalAlignment = Alignment.CenterVertically
		) {
			Image(
				painter = rememberAsyncImagePainter(model = imageUrl),
				contentDescription = null,
				modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
                    .background(Color.Gray)
			)
			Spacer(modifier = Modifier.width(16.dp))
			Text(
				text = characterName
			)
		}
	}

}

@Preview
@Composable
fun CharactersItemListPreview() {
	CharactersItemList(
		imageUrl = "",characterName = "Nom du personnage"
	)
}
