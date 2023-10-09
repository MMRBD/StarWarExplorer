package com.mmrbd.starwarsexplorer.domain.entities

import com.mmrbd.starwarsexplorer.base.adapters.ListItem

data class StarshipEntity(
    val name: String,
    val model: String,
    val manufacturer: String,
    val costInCredits: String,
    val length: String,
    val maxAtmospheringSpeed: String,
    val crew: String,
    val passengers: String,
    val cargoCapacity: String,
    val consumables: String,
    val hyperDriveRating: String,
    val mglt: String,
    val starshipClass: String,
    val pilots: List<String>,
    val films: List<String>,
    val created: String,
    val edited: String,
    val url: String
) : ListItem()
