package com.mmrbd.starwarsexplorer.presentation.planet

import android.os.Bundle
import android.widget.LinearLayout
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.mmrbd.starwarsexplorer.base.fragment.BaseFragment
import com.mmrbd.starwarsexplorer.databinding.FragmentPlanetBinding
import com.mmrbd.starwarsexplorer.presentation.planet.adapter.PlanetAdapter
import com.mmrbd.starwarsexplorer.presentation.planet.contract.PlanetContract
import com.mmrbd.starwarsexplorer.utils.AppLogger
import com.mmrbd.starwarsexplorer.utils.Result
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class PlanetFragment :
    BaseFragment<PlanetContract.State, FragmentPlanetBinding>(FragmentPlanetBinding::inflate) {

    private lateinit var adapter: PlanetAdapter

    override val model: PlanetViewModel by viewModels()

    override fun FragmentPlanetBinding.initialiseView(savedInstanceState: Bundle?) {
        adapter = PlanetAdapter {

        }
        rcvPlanet.layoutManager = LinearLayoutManager(context)
        rcvPlanet.adapter = adapter
        rcvPlanet.addItemDecoration(
            DividerItemDecoration(
                rcvPlanet.context,
                LinearLayout.VERTICAL
            )
        )


    }

    override fun FragmentPlanetBinding.render(viewState: PlanetContract.State) {
        when (viewState) {
            is PlanetContract.State.GetPlanetList -> {

                when (viewState.data) {
                    is Result.Success -> {
                        progressBarLoading.isVisible = false
                        adapter.submitList(viewState.data.data)

                        AppLogger.log("FragmentPlanetBinding:: ${viewState.data.data}")
                    }

                    is Result.Loading -> {
                        progressBarLoading.isVisible = true
                    }

                    is Result.Error -> {
                        progressBarLoading.isVisible = false
//                        Toast.makeText(
//                            context,
//                            viewState.data.error!!.message,
//                            Toast.LENGTH_SHORT
//                        ).show()

                    }

                    else -> {}
                }
            }

            else -> {}
        }
    }

}