package com.mmrbd.starwarsexplorer.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.mmrbd.starwarsexplorer.base.vm.BaseViewModel
import com.mmrbd.starwarsexplorer.utils.AppLogger
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

abstract class BaseFragment<ViewState : Any, Binding : ViewBinding>(private val bindingInflater: (LayoutInflater) -> Binding) :
    Fragment() {
    private var binding: Binding? = null
    private var viewScope = MainScope()

    abstract val model: BaseViewModel<ViewState, *>

    final override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = bindingInflater(layoutInflater)
        AppLogger.log("FRAGMENT BINDING:::: ${binding?.javaClass}") //
        return binding!!.root
    }

    final override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewScope.cancel()

        viewScope = MainScope()

        binding!!.initialiseView(savedInstanceState)

        model.viewStates()
            .forEach { it.onEach { viewState -> binding!!.render(viewState) }.launchIn(viewScope) }
    }

    /** Override to initialise view */
    open fun Binding.initialiseView(savedInstanceState: Bundle?) {
        // Template
    }

    protected open fun Binding.render(viewState: ViewState) {
        // template
    }

    override fun onDestroyView() {
        binding = null
        viewScope.cancel()
        super.onDestroyView()
    }
}