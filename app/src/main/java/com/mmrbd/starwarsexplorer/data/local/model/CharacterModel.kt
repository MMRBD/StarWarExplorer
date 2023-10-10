package com.mmrbd.starwarsexplorer.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mmrbd.starwarsexplorer.domain.entities.CharacterEntity

@Entity(tableName = "sw_character")
data class CharacterModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String?,
    val height: String?,
    val mass: String?,
    val hairColor: String?,
    val skinColor: String?,
    val eyeColor: String?,
    val birthYear: String?,
    val gender: String?,
    val homeWorld: String?,
    val created: String?,
    val edited: String?,
    val url: String?
)

fun CharacterModel.toDomain() = CharacterEntity(
    name = name,
    height = height,
    mass = mass,
    hairColor = hairColor,
    skinColor = skinColor,
    eyeColor = eyeColor,
    birthYear = birthYear,
    gender = gender,
    homeWorld = homeWorld,
    films = null,
    species = null,
    vehicles = null,
    starships = null,
    created = created,
    edited = edited,
    url = url
)
