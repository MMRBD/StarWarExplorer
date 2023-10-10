package com.mmrbd.starwarsexplorer.presentation.starship

import com.mmrbd.starwarsexplorer.base.vm.BaseViewModel
import com.mmrbd.starwarsexplorer.domain.usecases.GetStarshipsUserCase
import com.mmrbd.starwarsexplorer.presentation.starship.contract.StarshipContract
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject


@HiltViewModel
class StarshipViewModel @Inject constructor(
    private val getStarshipsUserCase: GetStarshipsUserCase
) : BaseViewModel<StarshipContract.State, StarshipContract.Event>() {

    init {
        query {
            getStarshipsUserCase.invoke().map {
                StarshipContract.State.GetStarshipList(it)
            }

        }

    }

    override fun onTriggerEvent(eventType: StarshipContract.Event) {
        TODO("Not yet implemented")
    }

}