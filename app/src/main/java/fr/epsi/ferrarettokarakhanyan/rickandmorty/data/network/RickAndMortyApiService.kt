package fr.epsi.ferrarettokarakhanyan.rickandmorty.data.network

import android.util.Log
import fr.epsi.ferrarettokarakhanyan.rickandmorty.data.network.model.CharacterResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


interface RetrofitService {
	@GET("character")
	fun getAllCharacter(
		@Query("page") page : Int = 1
	) : Call<CharacterResult>
}

object RickAndMortyApiService {
	private val retrofit : Retrofit = Retrofit.Builder().baseUrl("https://rickandmortyapi.com/api/")
		.addConverterFactory(GsonConverterFactory.create()).build()

	val service : RetrofitService by lazy {
		retrofit.create(RetrofitService::class.java)
	}

	// Centralized function for API call to reduce redundancy
	fun <T> executeApiCall(
		call : Call<T>,onSuccess : (Response<T>) -> Unit,onFailure : (Throwable) -> Unit = {
			Log.e(
				"RetrofitClient","API Call Failed",it
			)
		}
	) {
		call.enqueue(object : Callback<T> {
			override fun onResponse(call : Call<T>,response : Response<T>) {
				if (response.isSuccessful) {
					onSuccess(response)
				}
			}

			override fun onFailure(call : Call<T>,t : Throwable) {
				onFailure(t)
			}
		})
	}
}
