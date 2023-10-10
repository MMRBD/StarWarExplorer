package com.mmrbd.starwarsexplorer.di

import android.content.Context
import androidx.room.Room
import com.mmrbd.starwarsexplorer.data.local.dao.CharacterDao
import com.mmrbd.starwarsexplorer.data.local.dao.PlanetDao
import com.mmrbd.starwarsexplorer.data.local.dao.StarshipDao
import com.mmrbd.starwarsexplorer.data.local.db.StarWarsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideStarWarsDatabase(@ApplicationContext context: Context): StarWarsDatabase =
        Room.databaseBuilder(context, StarWarsDatabase::class.java, "star_war.db").build()

    @Provides
    fun provideCharacterDao(database: StarWarsDatabase): CharacterDao = database.characterDao()

    @Provides
    fun providePlanetDao(database: StarWarsDatabase): PlanetDao = database.PlanetDao()

    @Provides
    fun provideStarshipDao(database: StarWarsDatabase): StarshipDao = database.StarshipDao()
}