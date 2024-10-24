package fr.epsi.ferrarettokarakhanyan.rickandmorty.data.network.model

import com.google.gson.annotations.SerializedName

data class Character(
	@field:SerializedName("image") val image : String? = null,
	@field:SerializedName("gender") val gender : String? = null,
	@field:SerializedName("species") val species : String? = null,
	@field:SerializedName("created") val created : String? = null,
	@field:SerializedName("origin") val origin : NamedAPIResource = NamedAPIResource(),
	@field:SerializedName("name") val name : String = String(),
	@field:SerializedName("location") val location : NamedAPIResource = NamedAPIResource(),
	@field:SerializedName("episode") val episode : List<String> = listOf(),
	@field:SerializedName("id") val id : Int = 0,
	@field:SerializedName("type") val type : String? = null,
	@field:SerializedName("url") val url : String? = null,
	@field:SerializedName("status") val status : String? = null
)