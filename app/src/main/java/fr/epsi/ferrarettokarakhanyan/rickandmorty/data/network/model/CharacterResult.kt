package fr.epsi.ferrarettokarakhanyan.rickandmorty.data.network.model

import com.google.gson.annotations.SerializedName

data class CharacterResult(
	@field:SerializedName("results") val results : List<Character>? = null,
	@field:SerializedName("info") val info : Info? = null
)
