package com.mmrbd.starwarsexplorer.domain.entities

import android.os.Parcelable
import com.mmrbd.starwarsexplorer.base.adapters.ListItem

import kotlinx.parcelize.Parcelize

@Parcelize
data class CharacterEntity(
    val name: String?,
    val height: String?,
    val mass: String?,
    val hairColor: String?,
    val skinColor: String?,
    val eyeColor: String?,
    val birthYear: String?,
    val gender: String?,
    val homeWorld: String?,
    val films: List<String>?,
    val species: List<String>?,
    val vehicles: List<String>?,
    val starships: List<String>?,
    val created: String?,
    val edited: String?,
    val url: String?
) : ListItem(), Parcelable