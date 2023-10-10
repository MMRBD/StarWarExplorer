package com.mmrbd.starwarsexplorer.presentation.planet

import com.mmrbd.starwarsexplorer.base.vm.BaseViewModel
import com.mmrbd.starwarsexplorer.domain.usecases.GetPlanetsUserCase
import com.mmrbd.starwarsexplorer.presentation.planet.contract.PlanetContract
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject


@HiltViewModel
class PlanetViewModel @Inject constructor(
    private val getPlanetsUserCase: GetPlanetsUserCase
) : BaseViewModel<PlanetContract.State, PlanetContract.Event>() {

    init {
        query {
            getPlanetsUserCase.invoke().map {
                PlanetContract.State.GetPlanetList(it)
            }
        }
    }

    override fun onTriggerEvent(eventType: PlanetContract.Event) {
        TODO("Not yet implemented")
    }


}