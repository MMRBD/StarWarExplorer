package com.mmrbd.starwarsexplorer.domain.usecases

import com.mmrbd.starwarsexplorer.data.remote.error.Failure
import com.mmrbd.starwarsexplorer.data.remote.models.toCharacterDomain
import com.mmrbd.starwarsexplorer.data.repository.StarWarsRepositoryImpl
import com.mmrbd.starwarsexplorer.utils.Result
import com.mmrbd.starwarsexplorer.utils.TestDataUtils
import io.kotlintest.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.unmockkObject
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Test


class GetCharactersUserCaseTest {
    private val starWarsRepository by lazy {
        mockk<StarWarsRepositoryImpl>()
    }

    @Test
    fun `Get character successful`() {
        every {
            starWarsRepository.getCharacters()
        } returns flowOf(
            Result.Success(
                TestDataUtils.getCharacterTestData().map { it.toCharacterDomain() }
            )
        )
        val result = starWarsRepository.getCharacters()

        runBlocking {
            (result.first() is Result.Success) shouldBe true
        }
    }

    @Test
    fun `Get character failed`() {
        every {
            starWarsRepository.getCharacters()
        } returns flowOf(
            Result.Error(
                Failure.Exception(Throwable("Test error"))
            )
        )
        val result = starWarsRepository.getCharacters()

        runBlocking {
            (result.first() is Result.Error) shouldBe true
        }
    }

    @After
    fun tearDown() {
        unmockkObject(starWarsRepository)
    }
}