package com.mmrbd.starwarsexplorer.presentation

import com.mmrbd.starwarsexplorer.base.contract.BaseContract
import com.mmrbd.starwarsexplorer.base.vm.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ManinViewModel @Inject constructor(

) : BaseViewModel<BaseContract.State, BaseContract.Event>() {
    override fun onTriggerEvent(eventType: BaseContract.Event) {
        TODO("Not yet implemented")
    }
}