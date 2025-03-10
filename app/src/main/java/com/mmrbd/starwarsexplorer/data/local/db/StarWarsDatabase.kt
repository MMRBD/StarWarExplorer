package com.mmrbd.starwarsexplorer.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
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

class Example constructor(private val param1: String) {

    init {
        println("init is called.")
    }

    //First secondary constructor
    constructor(
        param1: String,
        param2: String) : this(param1) {

        println("Second constructor is called")
    }

    //Second secondary constructor
    constructor(
        param1: String,
        param2: String,
        param3: String) : this(param1) {

        println("Third constructor is called")
    }
}

val a = Example("")
