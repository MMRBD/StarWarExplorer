package com.mmrbd.starwarsexplorer.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mmrbd.starwarsexplorer.data.local.model.CharacterModel

@Dao
interface CharacterDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(characters: List<CharacterModel>)

    @Query("SELECT * FROM sw_character")
    fun getCharacters(): List<CharacterModel>

    @Query("DELETE FROM sw_character")
    fun deleteCharacters()
}