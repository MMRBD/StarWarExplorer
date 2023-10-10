package com.mmrbd.starwarsexplorer.base.contract

class BaseContract {
    sealed class State {
        object BaseState : State()
    }
    sealed class Event {
        object BaseEvent : Event()
    }
}
