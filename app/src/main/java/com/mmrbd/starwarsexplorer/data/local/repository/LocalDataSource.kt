package com.mmrbd.starwarsexplorer.data.local.repository

import com.mmrbd.starwarsexplorer.domain.entities.CharacterEntity
import com.mmrbd.starwarsexplorer.domain.entities.PlanetEntity
import com.mmrbd.starwarsexplorer.domain.entities.StarshipEntity
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    fun saveCharacters(characterEntity: List<CharacterEntity>)
    fun getCharacters(): Flow<List<CharacterEntity>>
    fun deleteCharacters()


    fun savePlanets(planetsEntity: List<PlanetEntity>)
    fun getPlanets(): Flow<List<PlanetEntity>>
    fun deletePlanets()

    fun saveStarships(starshipsEntity: List<StarshipEntity>)
    fun getStarships(): Flow<List<StarshipEntity>>
    fun deleteStarships()
}