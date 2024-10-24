package fr.epsi.ferrarettokarakhanyan.rickandmorty.data.network.model

import com.google.gson.annotations.SerializedName

data class Info(
	@field:SerializedName("next") val next : String? = null,
	@field:SerializedName("pages") val pages : Int = 0,
	@field:SerializedName("prev") val prev : String? = null,
	@field:SerializedName("count") val count : Int = 0
)
