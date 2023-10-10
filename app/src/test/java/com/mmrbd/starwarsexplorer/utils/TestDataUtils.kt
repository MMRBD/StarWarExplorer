package com.mmrbd.starwarsexplorer.utils

import com.mmrbd.starwarsexplorer.data.local.model.PlanetModel
import com.mmrbd.starwarsexplorer.data.local.model.StarshipModel
import com.mmrbd.starwarsexplorer.data.remote.models.CharacterModel
import com.mmrbd.starwarsexplorer.data.remote.models.PlanetData
import com.mmrbd.starwarsexplorer.data.remote.models.StarshipData

object TestDataUtils {

    fun getCharacterTestData(): List<CharacterModel> {
        val character = CharacterModel(
            "Test Name 1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            emptyList(),
            emptyList(),
            emptyList(),
            emptyList(),
            "",
            "",
            ""
        )

        return listOf(character)
    }


    fun getPlanetTestData(): List<PlanetData> {
        val planet1 = PlanetData(
            "Test Planet 1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            emptyList(),
            emptyList(),
            "",
            "",
            ""
        )
        val planet2 = PlanetData(
            "Test Planet 2",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            emptyList(),
            emptyList(),
            "",
            "",
            ""
        )
        return listOf(planet1, planet2)
    }

    fun getStarshipTestData(): List<StarshipData> {
        val starship1 = StarshipData(
            "Test Starship 1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            emptyList(),
            emptyList(),
            "",
            "",
            ""
        )
        val starship2 = StarshipData(
            "Test Starship 2",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            emptyList(),
            emptyList(),
            "",
            "",
            ""
        )
        return listOf(starship1, starship2)
    }
}