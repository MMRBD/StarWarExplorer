package com.mmrbd.starwarsexplorer.data.remote.repository

import com.mmrbd.starwarsexplorer.data.remote.models.toCharacterDomain
import com.mmrbd.starwarsexplorer.data.remote.models.toPlanetDomain
import com.mmrbd.starwarsexplorer.data.remote.api.StarWarApiEndpoint
import com.mmrbd.starwarsexplorer.data.remote.error.Failure
import com.mmrbd.starwarsexplorer.data.remote.error.getErrorTypeByHTTPCode
import com.mmrbd.starwarsexplorer.domain.entities.CharacterEntity
import com.mmrbd.starwarsexplorer.domain.entities.PlanetEntity
import com.mmrbd.starwarsexplorer.domain.entities.StarshipEntity
import com.mmrbd.starwarsexplorer.utils.AppLogger
import com.mmrbd.starwarsexplorer.utils.Result
import java.net.UnknownHostException

class RemoteDataSourceImpl(
    private val starWarApiEndpoint: StarWarApiEndpoint,
) : RemoteDataSource {


    override suspend fun getCharacters(): Result<List<CharacterEntity>> =
        try {
            Result.Loading<Nothing>()
            val result = starWarApiEndpoint.getStarWarsCharacter()
            if (result.isSuccessful) {
                AppLogger.log("getCharacters:: $result")
                Result.Success(result.body()!!.results.map { it.toCharacterDomain() })
            } else {
                Result.Error(
                    getErrorTypeByHTTPCode(result.code())
                )
            }
        } catch (exception: Throwable) {
            when (exception) {
                is UnknownHostException -> {
                    Result.Error((Failure.HTTP.NetworkConnection))
                }

                else -> {
                    Result.Error(Failure.Exception(exception))
                }
            }
        }


    override suspend fun getPlanets(): Result<List<PlanetEntity>> =
        try {
            Result.Loading<Nothing>()
            val result = starWarApiEndpoint.getPlants()
            if (result.isSuccessful) {
                AppLogger.log("getPlanets:: $result")
                Result.Success(result.body()!!.results.map { it.toPlanetDomain() })
            } else {
                Result.Error(
                    getErrorTypeByHTTPCode(result.code())
                )
            }
        } catch (exception: Throwable) {
            when (exception) {
                is UnknownHostException -> {
                    Result.Error((Failure.HTTP.NetworkConnection))
                }

                else -> {
                    Result.Error(Failure.Exception(exception))
                }
            }
        }

    override suspend fun getStarships(): Result<List<StarshipEntity>> =
        try {
            Result.Loading<Nothing>()
            val result = starWarApiEndpoint.getStarShips()
            if (result.isSuccessful) {
                AppLogger.log("getStarships:: $result")
                Result.Success(result.body()!!.results.map { it.toPlanetDomain() })
            } else {
                Result.Error(
                    getErrorTypeByHTTPCode(result.code())
                )
            }
        } catch (exception: Throwable) {
            when (exception) {
                is UnknownHostException -> {
                    Result.Error((Failure.HTTP.NetworkConnection))
                }

                else -> {
                    Result.Error(Failure.Exception(exception))
                }
            }
        }
}