package com.mmrbd.starwarsexplorer.base.navigation

import androidx.navigation.NavDirections

sealed class NavEvent {
    data class ToDirection(val directions: NavDirections) : NavEvent()
    data class ShowToast(val message: String) : NavEvent()
    object Back : NavEvent()
}
