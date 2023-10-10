package com.mmrbd.starwarsexplorer.data.local.repository

import com.mmrbd.starwarsexplorer.data.local.dao.CharacterDao
import com.mmrbd.starwarsexplorer.data.local.dao.PlanetDao
import com.mmrbd.starwarsexplorer.data.local.dao.StarshipDao
import com.mmrbd.starwarsexplorer.data.local.model.toDomain
import com.mmrbd.starwarsexplorer.data.mapper.toDataModel
import com.mmrbd.starwarsexplorer.domain.entities.CharacterEntity
import com.mmrbd.starwarsexplorer.domain.entities.PlanetEntity
import com.mmrbd.starwarsexplorer.domain.entities.StarshipEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val characterDao: CharacterDao,
    private val planetDao: PlanetDao,
    private val starshipDao: StarshipDao
) : LocalDataSource {
    override fun saveCharacters(characterEntity: List<CharacterEntity>) {
        characterDao.insert(characterEntity.map { it.toDataModel() })
    }

    override fun getCharacters(): Flow<List<CharacterEntity>> = flow {
        emit(characterDao.getCharacters().map { it.toDomain() })
    }


    override fun deleteCharacters() {
        characterDao.deleteCharacters()
    }

    override fun savePlanets(planetsEntity: List<PlanetEntity>) {
        planetDao.insert(planetsEntity.map { it.toDataModel() })
    }

    override fun getPlanets(): Flow<List<PlanetEntity>> = flow {
        emit(planetDao.getPlanets().map { it.toDomain() })
    }


    override fun deletePlanets() {
        planetDao.deletePlanets()
    }

    override fun saveStarships(starshipsEntity: List<StarshipEntity>) {
        starshipDao.insert(starshipsEntity.map { it.toDataModel() })
    }

    override fun getStarships(): Flow<List<StarshipEntity>> = flow {
        emit(starshipDao.getStarships().map { it.toDomain() })
    }

    override fun deleteStarships() {
        starshipDao.deleteStarships()
    }


}