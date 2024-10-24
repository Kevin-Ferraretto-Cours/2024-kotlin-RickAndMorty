package fr.epsi.ferrarettokarakhanyan.rickandmorty.data.network

import fr.epsi.ferrarettokarakhanyan.rickandmorty.data.network.model.CharacterResult
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path


interface GitHubService {
	@GET("character?page={page}")
	fun getAllCharacter(
		@Path("page") page : Int = 1
	) : Call<List<CharacterResult>>
}

class RickAndMortyApiService {
	private var retrofit : Retrofit =
		Retrofit.Builder().baseUrl("https://rickandmortyapi.com/api/").build()

	var service = retrofit.create(GitHubService::class.java)
}
