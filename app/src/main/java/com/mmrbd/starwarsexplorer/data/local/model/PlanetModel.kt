package com.mmrbd.starwarsexplorer.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.mmrbd.starwarsexplorer.domain.entities.PlanetEntity

@Entity(tableName = "sw_planet")
data class PlanetModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val rotationPeriod: String,
    val orbitalPeriod: String,
    val diameter: String,
    val climate: String,
    val gravity: String,
    val terrain: String,
    val surfaceWater: String,
    val population: String,
    val residents: List<String>,
    val films: List<String>,
    val created: String,
    val edited: String,
    val url: String
)

fun PlanetModel.toDomain() = PlanetEntity(
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
