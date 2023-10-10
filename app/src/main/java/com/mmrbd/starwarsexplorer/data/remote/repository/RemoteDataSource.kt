package com.mmrbd.starwarsexplorer.data.remote.repository

import com.mmrbd.starwarsexplorer.domain.entities.CharacterEntity
import com.mmrbd.starwarsexplorer.domain.entities.PlanetEntity
import com.mmrbd.starwarsexplorer.domain.entities.StarshipEntity
import com.mmrbd.starwarsexplorer.utils.Result

interface RemoteDataSource {
     suspend fun getCharacters(): Result<List<CharacterEntity>>
    suspend fun getPlanets(): Result<List<PlanetEntity>>
    suspend fun getStarships(): Result<List<StarshipEntity>>
}