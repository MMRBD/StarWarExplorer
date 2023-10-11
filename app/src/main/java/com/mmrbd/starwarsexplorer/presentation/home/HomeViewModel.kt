package com.mmrbd.starwarsexplorer.presentation.home

import com.mmrbd.starwarsexplorer.base.vm.BaseViewModel
import com.mmrbd.starwarsexplorer.domain.usecases.GetCharactersUserCase
import com.mmrbd.starwarsexplorer.presentation.home.contract.HomeContract
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCharactersUserCase: GetCharactersUserCase
) : BaseViewModel<HomeContract.State, HomeContract.Event>() {
    init {
        query {
            getCharactersUserCase.invoke().map {
                HomeContract.State.GetCharacterList(it)
            }
        }
    }

    override fun onTriggerEvent(eventType: HomeContract.Event) {
        when (eventType) {
            is HomeContract.Event.GotoDetailsPage -> {
                navigate(HomeFragmentDirections.actionNavHomeToNavCharacterDetails(eventType.characterEntity))
            }
        }
    }
}