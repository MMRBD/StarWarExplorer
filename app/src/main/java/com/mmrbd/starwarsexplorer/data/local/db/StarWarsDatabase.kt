package com.mmrbd.starwarsexplorer.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.mmrbd.starwarsexplorer.data.local.dao.CharacterDao
import com.mmrbd.starwarsexplorer.data.local.dao.PlanetDao
import com.mmrbd.starwarsexplorer.data.local.dao.StarshipDao
import com.mmrbd.starwarsexplorer.data.local.model.CharacterModel
import com.mmrbd.starwarsexplorer.data.local.model.Converters
import com.mmrbd.starwarsexplorer.data.local.model.PlanetModel
import com.mmrbd.starwarsexplorer.data.local.model.StarshipModel
import javax.annotation.meta.TypeQualifier


@Database(
    entities = [CharacterModel::class, PlanetModel::class, StarshipModel::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class StarWarsDatabase : RoomDatabase() {

    abstract fun characterDao(): CharacterDao
    abstract fun PlanetDao(): PlanetDao
    abstract fun StarshipDao(): StarshipDao

}