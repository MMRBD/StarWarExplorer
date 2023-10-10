package com.mmrbd.starwarsexplorer.presentation.details

import com.mmrbd.starwarsexplorer.base.vm.BaseViewModel
import com.mmrbd.starwarsexplorer.presentation.details.contract.CharacterDetailsContract

class CharacterDetailsViewModel :
    BaseViewModel<CharacterDetailsContract.State, CharacterDetailsContract.Event>() {
    override fun onTriggerEvent(eventType: CharacterDetailsContract.Event) {
        TODO("Not yet implemented")
    }
}