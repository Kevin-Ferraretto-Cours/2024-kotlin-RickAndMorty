import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import fr.epsi.ferrarettokarakhanyan.rickandmorty.data.network.model.Character
import fr.epsi.ferrarettokarakhanyan.rickandmorty.data.network.model.NamedAPIResource
import fr.epsi.ferrarettokarakhanyan.rickandmorty.ui.theme.RickAndMortyTheme

@Composable
fun CharactersDetail(character: Character, modifier: Modifier = Modifier) {
	Column(
		modifier = modifier
			.fillMaxWidth()
			.padding(16.dp),
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		Image(
			painter = rememberAsyncImagePainter(character.image),
			contentDescription = "Character Image",
			modifier = Modifier
				.size(128.dp)
				.clip(CircleShape)
				.background(Color.Gray),
			contentScale = ContentScale.Crop
		)
		Spacer(modifier = Modifier.height(16.dp))
		Text(
			text = character.name,
			style = MaterialTheme.typography.titleLarge,
			textAlign = TextAlign.Center
		)
		Spacer(modifier = Modifier.height(8.dp))
		Text(
			text = "Gender: ${character.gender ?: "Unknown"}",
			style = MaterialTheme.typography.bodyMedium
		)
		Text(
			text = "Species: ${character.species ?: "Unknown"}",
			style = MaterialTheme.typography.bodyMedium
		)
		Text(
			text = "Status: ${character.status ?: "Unknown"}",
			style = MaterialTheme.typography.bodyMedium
		)
		Spacer(modifier = Modifier.height(8.dp))
		Text(
			text = "Origin: ${character.origin.name}",
			style = MaterialTheme.typography.bodySmall
		)
		Text(
			text = "Location: ${character.location.name}",
			style = MaterialTheme.typography.bodySmall
		)
	}
}

@Preview
@Composable
private fun CharactersDetailPreview() {
	val character = Character(
		image = "https://example.com/character.jpg",
		name = "Rick Sanchez",
		gender = "Male",
		species = "Human",
		status = "Alive",
		origin = NamedAPIResource(name = "Earth"),
		location = NamedAPIResource(name = "Earth C-137")
	)
	RickAndMortyTheme {
		CharactersDetail(character = character)
	}
}
