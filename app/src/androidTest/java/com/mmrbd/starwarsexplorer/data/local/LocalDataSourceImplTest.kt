package com.mmrbd.starwarsexplorer.data.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.mmrbd.starwarsexplorer.data.local.dao.CharacterDao
import com.mmrbd.starwarsexplorer.data.local.dao.PlanetDao
import com.mmrbd.starwarsexplorer.data.local.dao.StarshipDao
import com.mmrbd.starwarsexplorer.data.local.db.StarWarsDatabase
import com.mmrbd.starwarsexplorer.utils.TestDataUtils
import com.mmrbd.starwarsexplorer.utils.TestDataUtils.getCharacterTestData
import com.mmrbd.starwarsexplorer.utils.TestDataUtils.getPlanetTestData
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class LocalDataSourceImplTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: StarWarsDatabase
    private lateinit var characterDao: CharacterDao
    private lateinit var planetDao: PlanetDao
    private lateinit var starshipDao: StarshipDao

    @Before
    fun setUp() {
        database =
            Room.inMemoryDatabaseBuilder(
                ApplicationProvider.getApplicationContext(),
                StarWarsDatabase::class.java
            ).allowMainThreadQueries().build()

        characterDao = database.characterDao()
        planetDao = database.PlanetDao()
        starshipDao = database.StarshipDao()
    }


    @Test
    fun saveCharacters_returnsTrue() = runBlocking {
        characterDao.insert(getCharacterTestData())

        val result = characterDao.getCharacters()

        assertEquals(2, result.size)
        assertEquals(getCharacterTestData()[0].name, result[0].name)
        assertEquals(getCharacterTestData()[1].name, result[1].name)
    }

    @Test
    fun getCharacters_returnsTrue() = runBlocking {
        characterDao.insert(getCharacterTestData())

        val result = characterDao.getCharacters()

        assertEquals(2, result.size)
    }

    @Test
    fun deleteCharacters_returnsTrue() = runBlocking {
        characterDao.insert(getCharacterTestData())
        characterDao.deleteCharacters()

        val result = characterDao.getCharacters()

        assertEquals(0, result.size)
    }

    @Test
    fun savePlanets_returnTrue() = runBlocking {
        planetDao.insert(getPlanetTestData())

        val result = planetDao.getPlanets()

        assertEquals(2, result.size)
        assertEquals(getPlanetTestData()[0].name, result[0].name)
        assertEquals(getPlanetTestData()[1].name, result[1].name)
    }

    @Test
    fun getPlanets_returnTrue() = runBlocking {
        planetDao.insert(getPlanetTestData())

        val result = planetDao.getPlanets()

        assertEquals(2, result.size)
    }

    @Test
    fun deletePlanets_returnsTrue() = runBlocking {
        planetDao.insert(getPlanetTestData())

        planetDao.deletePlanets()

        val result = planetDao.getPlanets()

        assertEquals(0, result.size)
    }

    @Test
    fun saveStarships_returnTrue() = runBlocking {
        starshipDao.insert(TestDataUtils.getStarshipTestData())

        val result = starshipDao.getStarships()

        assertEquals(2, result.size)
        assertEquals(TestDataUtils.getStarshipTestData()[0].name, result[0].name)
        assertEquals(TestDataUtils.getStarshipTestData()[1].name, result[1].name)
    }

    @Test
    fun getStarships_returnTrue() = runBlocking {
        starshipDao.insert(TestDataUtils.getStarshipTestData())

        val result = starshipDao.getStarships()

        assertEquals(2, result.size)
    }

    @Test
    fun deleteStarships_returnTrue() = runBlocking {
        starshipDao.insert(TestDataUtils.getStarshipTestData())
        starshipDao.deleteStarships()

        val result = starshipDao.getStarships()

        assertEquals(0, result.size)
    }

    @After
    fun tearDown() {
        database.close()
    }

}