package com.mmrbd.starwarsexplorer.data.remote.models

import com.google.gson.annotations.SerializedName
import com.mmrbd.starwarsexplorer.domain.entities.PlanetEntity

data class PlanetDataModel(
    val count: Long,
    val next: String,
    val previous: String?,
    val results: List<PlanetData>
)

data class PlanetData(
    val name: String,
    @SerializedName("rotation_period")
    val rotationPeriod: String,
    @SerializedName("orbital_period")
    val orbitalPeriod: String,
    val diameter: String,
    val climate: String,
    val gravity: String,
    val terrain: String,

    @SerializedName("surface_water")
    val surfaceWater: String,
    val population: String,
    val residents: List<String>,
    val films: List<String>,
    val created: String,
    val edited: String,
    val url: String
)

fun PlanetData.toPlanetDomain() = PlanetEntity(
    name,
    rotationPeriod,
    orbitalPeriod,
    diameter,
    climate,
    gravity,
    terrain,
    surfaceWater,
    population,
    residents,
    films,
    created,
    edited,
    url
)