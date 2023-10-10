package com.mmrbd.starwarsexplorer.data.mapper

import com.mmrbd.starwarsexplorer.data.local.model.CharacterModel
import com.mmrbd.starwarsexplorer.data.local.model.PlanetModel
import com.mmrbd.starwarsexplorer.data.local.model.StarshipModel
import com.mmrbd.starwarsexplorer.domain.entities.CharacterEntity
import com.mmrbd.starwarsexplorer.domain.entities.PlanetEntity
import com.mmrbd.starwarsexplorer.domain.entities.StarshipEntity

fun CharacterEntity.toDataModel() = CharacterModel(
    id = 0,
    name = name,
    height = height,
    mass = mass,
    hairColor = hairColor,
    skinColor = skinColor,
    eyeColor = eyeColor,
    birthYear = birthYear,
    gender = gender,
    homeWorld = homeWorld,
    created = created,
    edited = edited,
    url = url
)

fun PlanetEntity.toDataModel() = PlanetModel(
    id = 0,
    name = name,
    rotationPeriod = rotationPeriod,
    orbitalPeriod = orbitalPeriod,
    diameter = diameter,
    climate = climate,
    gravity = gravity,
    terrain = terrain,
    surfaceWater = surfaceWater,
    population = population,
    residents = residents,
    films = films,
    created = created,
    edited = edited,
    url = url
)

fun StarshipEntity.toDataModel() = StarshipModel(
    0,
    name,
    model,
    manufacturer,
    costInCredits,
    length,
    maxAtmospheringSpeed,
    crew,
    passengers,
    cargoCapacity,
    consumables,
    hyperDriveRating,
    mglt,
    starshipClass,
    pilots,
    films,
    created,
    edited,
    url
)