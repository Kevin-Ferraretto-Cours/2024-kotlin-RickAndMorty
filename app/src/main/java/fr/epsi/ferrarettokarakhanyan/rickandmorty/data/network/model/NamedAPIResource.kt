package fr.epsi.ferrarettokarakhanyan.rickandmorty.data.network.model

import com.google.gson.annotations.SerializedName

data class NamedAPIResource(
	@field:SerializedName("name") val name : String = String(),
	@field:SerializedName("url") val url : String = String()
)