package com.mmrbd.starwarsexplorer.data.remote

import com.mmrbd.starwarsexplorer.data.remote.models.CharacterDataModel
import com.mmrbd.starwarsexplorer.data.remote.models.PlanetData
import com.mmrbd.starwarsexplorer.data.remote.models.PlanetDataModel
import com.mmrbd.starwarsexplorer.data.remote.models.StarshipDataModel
import com.mmrbd.starwarsexplorer.data.remote.api.StarWarApiEndpoint
import com.mmrbd.starwarsexplorer.utils.TestDataUtils.getCharacterTestData
import com.mmrbd.starwarsexplorer.utils.TestDataUtils.getPlanetTestData
import com.mmrbd.starwarsexplorer.utils.TestDataUtils.getStarshipTestData
import io.kotlintest.shouldBe
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Test
import retrofit2.Response


class RemoteDataSourceImplTest {

    private val starWarApiEndpoint by lazy {
        mockk<StarWarApiEndpoint>()
    }

    @Test
    fun getCharacters_success_result() = runBlocking {
        val responses =
            Response.success(CharacterDataModel(12, "", "", getCharacterTestData()))

        every {
            runBlocking {
                starWarApiEndpoint.getStarWarsCharacter()

            }
        } returns responses

        val actualResponse = starWarApiEndpoint.getStarWarsCharacter()

        actualResponse shouldBe responses
        getCharacterTestData() shouldBe responses.body()?.results
        getCharacterTestData().size shouldBe responses.body()?.results?.size
    }

    @Test
    fun getPlanets_success_result() = runBlocking {
        val responses =
            Response.success(PlanetDataModel(12, "", "", getPlanetTestData()))

        every {
            runBlocking {
                starWarApiEndpoint.getPlants()

            }
        } returns responses

        val actualResponse = starWarApiEndpoint.getPlants()

        actualResponse shouldBe responses
        getPlanetTestData() shouldBe responses.body()?.results
        getPlanetTestData().size shouldBe responses.body()?.results?.size
    }

    @Test
    fun getStarships_success_result() = runBlocking {
        val responses =
            Response.success(StarshipDataModel(12, "", "", getStarshipTestData()))

        every {
            runBlocking {
                starWarApiEndpoint.getStarShips()

            }
        } returns responses

        val actualResponse = starWarApiEndpoint.getStarShips()

        actualResponse shouldBe responses
        getStarshipTestData() shouldBe responses.body()?.results
        getStarshipTestData().size shouldBe responses.body()?.results?.size
    }

    @After
    fun shutdown() {
        clearAllMocks()
    }

}