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

class GetPlanetsUserCaseTest {

    private val starWarsRepository by lazy {
        mockk<StarWarsRepositoryImpl>()
    }

    @Test
    fun `Get planet successful`() {
        every {
            starWarsRepository.getPlanets()
        } returns flowOf(
            Result.Success(
                TestDataUtils.getPlanetTestData().map { it.toPlanetDomain() }
            )
        )
        val result = starWarsRepository.getPlanets()

        runBlocking {
            (result.first() is Result.Success) shouldBe true
        }
    }

    @Test
    fun `Get planet failed`() {
        every {
            starWarsRepository.getPlanets()
        } returns flowOf(
            Result.Error(
                Failure.Exception(Throwable("Test error"))
            )
        )
        val result = starWarsRepository.getPlanets()

        runBlocking {
            (result.first() is Result.Error) shouldBe true
        }
    }

    @After
    fun tearDown() {
        unmockkObject(starWarsRepository)
    }
}