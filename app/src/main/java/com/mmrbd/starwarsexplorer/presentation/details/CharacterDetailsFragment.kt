package com.mmrbd.starwarsexplorer.presentation.details

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.mmrbd.starwarsexplorer.base.fragment.BaseFragment
import com.mmrbd.starwarsexplorer.databinding.FragmentCharacterDetailsBinding
import com.mmrbd.starwarsexplorer.presentation.details.contract.CharacterDetailsContract
import com.mmrbd.starwarsexplorer.presentation.home.HomeViewModel
import com.mmrbd.starwarsexplorer.presentation.home.contract.HomeContract

class CharacterDetailsFragment :
    BaseFragment<CharacterDetailsContract.State, FragmentCharacterDetailsBinding>(
        FragmentCharacterDetailsBinding::inflate
    ) {

    override val model: CharacterDetailsViewModel by viewModels()

    override fun FragmentCharacterDetailsBinding.initialiseView(savedInstanceState: Bundle?) {

    }

    override fun FragmentCharacterDetailsBinding.render(viewState: CharacterDetailsContract.State) {

    }

}