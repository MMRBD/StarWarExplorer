package com.mmrbd.starwarsexplorer.domain.repositories

import com.mmrbd.starwarsexplorer.domain.entities.CharacterEntity
import com.mmrbd.starwarsexplorer.domain.entities.PlanetEntity
import com.mmrbd.starwarsexplorer.domain.entities.StarshipEntity
import com.mmrbd.starwarsexplorer.utils.Result
import kotlinx.coroutines.flow.Flow

interface StarWarsRepository {
    fun getCharacters(): Flow<Result<List<CharacterEntity>>>
    fun getCharacterDetails(id: Int): Flow<CharacterEntity>
    fun getPlanets(): Flow<Result<List<PlanetEntity>>>
    fun getStarships(): Flow<Result<List<StarshipEntity>>>
}