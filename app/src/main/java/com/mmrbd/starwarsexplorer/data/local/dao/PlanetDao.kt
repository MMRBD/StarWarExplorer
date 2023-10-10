package com.mmrbd.starwarsexplorer.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mmrbd.starwarsexplorer.data.local.model.CharacterModel
import com.mmrbd.starwarsexplorer.data.local.model.PlanetModel

@Dao
interface PlanetDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(characters: List<PlanetModel>)

    @Query("SELECT * FROM sw_planet")
    fun getPlanets(): List<PlanetModel>

    @Query("DELETE FROM sw_planet")
    fun deletePlanets()
}