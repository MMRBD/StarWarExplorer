package com.mmrbd.starwarsexplorer.data.remote.api

import com.mmrbd.starwarsexplorer.data.remote.models.CharacterDataModel
import com.mmrbd.starwarsexplorer.data.remote.models.PlanetDataModel
import com.mmrbd.starwarsexplorer.data.remote.models.StarshipDataModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface StarWarApiEndpoint {
    @GET("people")
    suspend fun getStarWarsCharacter(): Response<CharacterDataModel>

    @GET("people/{id}")
    suspend fun getStarWarsCharacterDetails(@Query("id") id: String): Response<CharacterDataModel>

    @GET("planets")
    suspend fun getPlants(): Response<PlanetDataModel>

    @GET("starships")
    suspend fun getStarShips(): Response<StarshipDataModel>
}