package com.mmrbd.starwarsexplorer.di

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
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
        Room.databaseBuilder(context, StarWarsDatabase::class.java, "star_war.db")
            .addMigrations(MIGRATION_1_2, MIGRATION_2_3)
            .build()

    @Provides
    fun provideCharacterDao(database: StarWarsDatabase): CharacterDao = database.characterDao()

    @Provides
    fun providePlanetDao(database: StarWarsDatabase): PlanetDao = database.PlanetDao()

    @Provides
    fun provideStarshipDao(database: StarWarsDatabase): StarshipDao = database.StarshipDao()


    private val MIGRATION_1_2 = object: Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
            TODO("Not yet implemented")
        }
    }

    private val MIGRATION_2_3 = object: Migration(2, 3) {
        override fun migrate(database: SupportSQLiteDatabase) {
            TODO("Not yet implemented")
        }
    }
}