package com.mmrbd.starwarsexplorer.data.remote.models

import com.google.gson.annotations.SerializedName
import com.mmrbd.starwarsexplorer.domain.entities.StarshipEntity

data class StarshipDataModel(
    val count: Long,
    val next: String,
    val previous: String?,
    val results: List<StarshipData>
)

data class StarshipData(
    val name: String,
    val model: String,
    val manufacturer: String,
    @SerializedName("cost_in_credits")
    val costInCredits: String,
    val length: String,
    @SerializedName("max_atmosphering_speed")
    val maxAtmospheringSpeed: String,
    val crew: String,
    val passengers: String,
    @SerializedName("cargo_capacity")
    val cargoCapacity: String,
    val consumables: String,
    @SerializedName("hyperdrive_rating")
    val hyperdriveRating: String,
    @SerializedName("MGLT")
    val mglt: String,
    @SerializedName("starship_class")
    val starshipClass: String,
    val pilots: List<String>,
    val films: List<String>,
    val created: String,
    val edited: String,
    val url: String
)

fun StarshipData.toPlanetDomain() = StarshipEntity(
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
    hyperdriveRating,
    mglt, starshipClass, pilots, films, created, edited, url
)