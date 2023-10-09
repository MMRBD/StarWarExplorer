package com.mmrbd.starwarsexplorer.domain.usecases

import com.mmrbd.starwarsexplorer.domain.entities.PlanetEntity
import com.mmrbd.starwarsexplorer.domain.repositories.StarWarsRepository
import com.mmrbd.starwarsexplorer.utils.Result
import kotlinx.coroutines.flow.Flow

class GetPlanetsUserCase(
    private val repository: StarWarsRepository
) {
    operator fun invoke(): Flow<Result<List<PlanetEntity>>> = repository.getPlanets()

}