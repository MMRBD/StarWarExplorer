package com.mmrbd.starwarsexplorer.presentation.home

import android.os.Bundle
import android.widget.LinearLayout.VERTICAL
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mmrbd.starwarsexplorer.R
import com.mmrbd.starwarsexplorer.base.fragment.BaseFragment
import com.mmrbd.starwarsexplorer.databinding.FragmentHomeBinding
import com.mmrbd.starwarsexplorer.presentation.home.adapter.CharacterAdapter
import com.mmrbd.starwarsexplorer.presentation.home.contract.HomeContract
import com.mmrbd.starwarsexplorer.utils.AppLogger
import com.mmrbd.starwarsexplorer.utils.Result
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment :
    BaseFragment<HomeContract.State, FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private lateinit var adapter: CharacterAdapter


    override val model: HomeViewModel by viewModels()

    override fun FragmentHomeBinding.initialiseView(savedInstanceState: Bundle?) {

        adapter = CharacterAdapter {
            Toast.makeText(context, it.name, Toast.LENGTH_SHORT).show()

            val bundle = Bundle()
            bundle.putParcelable("Key", it)

            findNavController().navigate(
                R.id.navCharacterDetails,
                bundle
            )
        }
        rcvStarWarsCharacter.layoutManager = LinearLayoutManager(context)
        rcvStarWarsCharacter.adapter = adapter

        rcvStarWarsCharacter.addItemDecoration(
            DividerItemDecoration(
                rcvStarWarsCharacter.context,
                VERTICAL
            )
        )

    }

    override fun FragmentHomeBinding.render(viewState: HomeContract.State) {
        when (viewState) {
            is HomeContract.State.GetCharacterList -> {

                when (viewState.data) {
                    is Result.Success -> {
                        progressBarLoading.isVisible = false
                        adapter.submitList(viewState.data.data)

                        AppLogger.log("GetCharacterList ${viewState.data.data}")
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