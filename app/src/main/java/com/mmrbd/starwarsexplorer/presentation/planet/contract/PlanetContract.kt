package com.mmrbd.starwarsexplorer.presentation.planet.contract

import com.mmrbd.starwarsexplorer.domain.entities.PlanetEntity
import com.mmrbd.starwarsexplorer.utils.Result

class PlanetContract {
    sealed class State {

        data class GetPlanetList(val data: Result<List<PlanetEntity>>) : State()
    }

    sealed class Event {}

}