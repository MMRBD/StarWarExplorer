package com.mmrbd.starwarsexplorer.presentation.home.contract

import com.mmrbd.starwarsexplorer.domain.entities.CharacterEntity
import com.mmrbd.starwarsexplorer.utils.Result

class HomeContract {
    sealed class State {
        data class GetCharacterList(val data: Result<List<CharacterEntity>>) : State()
    }

    sealed class Event {
        data class GotoDetailsPage(val characterEntity: CharacterEntity) : Event()

    }

}