package com.mmrbd.starwarsexplorer.data.remote.models

import com.google.gson.annotations.SerializedName
import com.mmrbd.starwarsexplorer.domain.entities.CharacterEntity


data class CharacterDataModel(
    val count: Long,
    val next: String,
    val previous: String?,
    val results: List<CharacterModel>
)

data class CharacterModel(
    val name: String?,
    val height: String?,
    val mass: String?,
    @SerializedName("hair_color")
    val hairColor: String?,
    @SerializedName("skin_color")
    val skinColor: String?,
    @SerializedName("eye_color")
    val eyeColor: String?,
    @SerializedName("birth_year")
    val birthYear: String?,
    val gender: String?,
    @SerializedName("homeworld")
    val homeWorld: String?,
    val films: List<String>?,
    val species: List<String>?,
    val vehicles: List<String>?,
    val starships: List<String>?,
    val created: String?,
    val edited: String?,
    val url: String?
)

fun CharacterModel.toCharacterDomain() = CharacterEntity(
    name = name,
    height = height,
    mass = mass,
    hairColor = hairColor,
    skinColor = skinColor,
    eyeColor = eyeColor,
    birthYear = birthYear,
    gender = gender,
    homeWorld = homeWorld,
    films = films,
    species = species,
    vehicles = vehicles,
    starships = starships,
    created = created,
    edited = edited,
    url = url
)

