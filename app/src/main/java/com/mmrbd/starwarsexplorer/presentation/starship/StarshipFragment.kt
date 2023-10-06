package com.mmrbd.starwarsexplorer.presentation.starship

import android.os.Bundle
import android.widget.LinearLayout
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.mmrbd.starwarsexplorer.base.fragment.BaseFragment
import com.mmrbd.starwarsexplorer.databinding.FragmentStarshipBinding
import com.mmrbd.starwarsexplorer.presentation.home.contract.HomeContract
import com.mmrbd.starwarsexplorer.presentation.starship.contract.StarshipContract
import com.mmrbd.starwarsexplorer.utils.AppLogger
import com.mmrbd.starwarsexplorer.utils.Result
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StarshipFragment :
    BaseFragment<StarshipContract.State, FragmentStarshipBinding>(FragmentStarshipBinding::inflate) {

    private lateinit var adapter: StarshipAdapter
    override val model: StarshipViewModel by viewModels()

    override fun FragmentStarshipBinding.initialiseView(savedInstanceState: Bundle?) {
        adapter = StarshipAdapter {

        }

        rcvStarship.layoutManager = LinearLayoutManager(context)
        rcvStarship.adapter = adapter

        rcvStarship.addItemDecoration(
            DividerItemDecoration(
                rcvStarship.context,
                LinearLayout.VERTICAL
            )
        )

    }

    override fun FragmentStarshipBinding.render(viewState: StarshipContract.State) {
        when (viewState) {
            is StarshipContract.State.GetStarshipList -> {

                when (viewState.data) {
                    is Result.Success -> {
                        progressBarLoading.isVisible = false
                        adapter.submitList(viewState.data.data)

                        AppLogger.log("FragmentStarshipBinding:: ${viewState.data.data}")
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