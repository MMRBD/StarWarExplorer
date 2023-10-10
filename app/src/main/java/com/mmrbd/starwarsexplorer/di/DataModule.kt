package com.mmrbd.starwarsexplorer.di

import com.mmrbd.starwarsexplorer.data.local.dao.CharacterDao
import com.mmrbd.starwarsexplorer.data.local.dao.PlanetDao
import com.mmrbd.starwarsexplorer.data.local.dao.StarshipDao
import com.mmrbd.starwarsexplorer.data.local.repository.LocalDataSource
import com.mmrbd.starwarsexplorer.data.local.repository.LocalDataSourceImpl
import com.mmrbd.starwarsexplorer.data.remote.api.StarWarApiEndpoint
import com.mmrbd.starwarsexplorer.data.remote.repository.RemoteDataSource
import com.mmrbd.starwarsexplorer.data.remote.repository.RemoteDataSourceImpl
import com.mmrbd.starwarsexplorer.data.repository.StarWarsRepositoryImpl
import com.mmrbd.starwarsexplorer.domain.repositories.StarWarsRepository
import com.mmrbd.starwarsexplorer.domain.usecases.GetCharactersUserCase
import com.mmrbd.starwarsexplorer.domain.usecases.GetPlanetsUserCase
import com.mmrbd.starwarsexplorer.domain.usecases.GetStarshipsUserCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideRemoteDataSource(starWarApiEndpoint: StarWarApiEndpoint): RemoteDataSource =
        RemoteDataSourceImpl(starWarApiEndpoint)

    @Provides
    @Singleton
    fun provideLocalDataSource(
        characterDao: CharacterDao,
        planetDao: PlanetDao,
        starshipDao: StarshipDao
    ): LocalDataSource =
        LocalDataSourceImpl(characterDao, planetDao, starshipDao)

    @Provides
    @Singleton
    fun provideStarWarsRepository(
        remoteDataSource: RemoteDataSource,
        localDataSource: LocalDataSource,
    ): StarWarsRepository = StarWarsRepositoryImpl(remoteDataSource, localDataSource)

    @Provides
    fun provideGetCharactersUserCase(repository: StarWarsRepository): GetCharactersUserCase =
        GetCharactersUserCase(repository)

    @Provides
    fun provideGetPlanetsUseCase(repository: StarWarsRepository): GetPlanetsUserCase =
        GetPlanetsUserCase(repository)

    @Provides
    fun provideGetStarshipsUseCase(repository: StarWarsRepository): GetStarshipsUserCase =
        GetStarshipsUserCase(repository)
}