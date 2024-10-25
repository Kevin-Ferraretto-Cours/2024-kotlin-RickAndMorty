package fr.epsi.ferrarettokarakhanyan.rickandmorty.data.network.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class NamedAPIResource(
	@field:SerializedName("name") val name : String = String(),
	@field:SerializedName("url") val url : String = String()
) : Parcelable