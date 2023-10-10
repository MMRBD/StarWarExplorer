package com.mmrbd.starwarsexplorer.domain.usecases

import com.mmrbd.starwarsexplorer.data.remote.error.Failure
import com.mmrbd.starwarsexplorer.data.remote.models.toPlanetDomain
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

class GetStarshipsUserCaseTest {


    private val starWarsRepository by lazy {
        mockk<StarWarsRepositoryImpl>()
    }

    @Test
    fun `Get starship successful`() {
        every {
            starWarsRepository.getStarships()
        } returns flowOf(
            Result.Success(
                TestDataUtils.getStarshipTestData().map { it.toPlanetDomain() }
            )
        )
        val result = starWarsRepository.getStarships()

        runBlocking {
            (result.first() is Result.Success) shouldBe true
        }
    }

    @Test
    fun `Get starship failed`() {
        every {
            starWarsRepository.getStarships()
        } returns flowOf(
            Result.Error(
                Failure.Exception(Throwable("Test error"))
            )
        )
        val result = starWarsRepository.getStarships()

        runBlocking {
            (result.first() is Result.Error) shouldBe true
        }
    }

    @After
    fun tearDown() {
        unmockkObject(starWarsRepository)
    }
}