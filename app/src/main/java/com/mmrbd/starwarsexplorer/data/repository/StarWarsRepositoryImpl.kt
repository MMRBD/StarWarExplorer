package com.mmrbd.starwarsexplorer.data.repository

import com.mmrbd.starwarsexplorer.data.local.repository.LocalDataSource
import com.mmrbd.starwarsexplorer.data.remote.repository.RemoteDataSource
import com.mmrbd.starwarsexplorer.domain.entities.CharacterEntity
import com.mmrbd.starwarsexplorer.domain.entities.PlanetEntity
import com.mmrbd.starwarsexplorer.domain.entities.StarshipEntity
import com.mmrbd.starwarsexplorer.domain.repositories.StarWarsRepository
import com.mmrbd.starwarsexplorer.utils.Result
import com.mmrbd.starwarsexplorer.utils.network.networkBoundResource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class StarWarsRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : StarWarsRepository {
    override fun getCharacters(): Flow<Result<List<CharacterEntity>>> = networkBoundResource(
        query = {
            localDataSource.getCharacters()
        },
        fetch = {
            remoteDataSource.getCharacters()
        },
        saveFetchResult = { characters ->
            localDataSource.deleteCharacters()
            localDataSource.saveCharacters(characters.data!!)
        },
        shouldFetch = {
            it.isEmpty()
        }
    )

    override fun getCharacterDetails(id: Int): Flow<CharacterEntity> {
        TODO("Not yet implemented")
    }

    override fun getPlanets(): Flow<Result<List<PlanetEntity>>> {
        return networkBoundResource(
            query = {
                localDataSource.getPlanets()
            },
            fetch = {
                remoteDataSource.getPlanets()
            },
            saveFetchResult = { planets ->
                localDataSource.deletePlanets()
                localDataSource.savePlanets(planets.data!!)
            },
            shouldFetch = {
                it.isEmpty()
            }
        )
    }

    override fun getStarships(): Flow<Result<List<StarshipEntity>>> {
        return networkBoundResource(
            query = {
                localDataSource.getStarships()
            },
            fetch = {
                remoteDataSource.getStarships()
            },
            saveFetchResult = { starships ->
                localDataSource.deleteStarships()
                localDataSource.saveStarships(starships.data!!)
            },
            shouldFetch = {
                it.isEmpty()
            }
        )
    }
}