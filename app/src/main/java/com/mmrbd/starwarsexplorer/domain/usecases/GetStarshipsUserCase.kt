package com.mmrbd.starwarsexplorer.domain.usecases

import com.mmrbd.starwarsexplorer.domain.entities.StarshipEntity
import com.mmrbd.starwarsexplorer.domain.repositories.StarWarsRepository
import com.mmrbd.starwarsexplorer.utils.Result
import kotlinx.coroutines.flow.Flow

class GetStarshipsUserCase(
    private val repository: StarWarsRepository
) {
    operator fun invoke(): Flow<Result<List<StarshipEntity>>> = repository.getStarships()
}