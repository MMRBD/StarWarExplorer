package com.mmrbd.starwarsexplorer.utils

import com.mmrbd.starwarsexplorer.data.local.model.CharacterModel
import com.mmrbd.starwarsexplorer.data.local.model.PlanetModel
import com.mmrbd.starwarsexplorer.data.local.model.StarshipModel

object TestDataUtils {

    fun getCharacterTestData(): List<CharacterModel> {
        val character = CharacterModel(
            0,
            "Test Name 1",
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
            ""
        )

        val character1 = CharacterModel(
            0,
            "Test Name 2",
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
            ""
        )
        return listOf(character, character1)
    }

    fun getPlanetTestData(): List<PlanetModel> {
        val planet1 = PlanetModel(
            0,
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
        val planet2 = PlanetModel(
            0,
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

    fun getStarshipTestData(): List<StarshipModel> {
        val starship1 = StarshipModel(
            0,
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
        val starship2 = StarshipModel(
            0,
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