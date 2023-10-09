package com.mmrbd.starwarsexplorer.domain.usecases

import com.mmrbd.starwarsexplorer.domain.entities.CharacterEntity
import com.mmrbd.starwarsexplorer.domain.repositories.StarWarsRepository
import com.mmrbd.starwarsexplorer.utils.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCharactersUserCase @Inject constructor(
    private val repository: StarWarsRepository
) {
    operator fun invoke(): Flow<Result<List<CharacterEntity>>> = repository.getCharacters()
}