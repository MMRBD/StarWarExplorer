package com.mmrbd.starwarsexplorer.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mmrbd.starwarsexplorer.data.local.model.StarshipModel

@Dao
interface StarshipDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(characters: List<StarshipModel>)

    @Query("SELECT * FROM sw_starship")
    fun getStarships(): List<StarshipModel>

    @Query("DELETE FROM sw_starship")
    fun deleteStarships()
}