package com.mmrbd.starwarsexplorer.presentation.starship.contract

import com.mmrbd.starwarsexplorer.domain.entities.StarshipEntity
import com.mmrbd.starwarsexplorer.utils.Result

class StarshipContract {
    sealed class State {

        data class GetStarshipList(val data: Result<List<StarshipEntity>>) : State()
    }

    sealed class Event {}

}