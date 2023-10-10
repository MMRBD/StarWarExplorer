package com.mmrbd.starwarsexplorer.presentation.details

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.mmrbd.starwarsexplorer.R
import com.mmrbd.starwarsexplorer.base.fragment.BaseFragment
import com.mmrbd.starwarsexplorer.databinding.FragmentCharacterDetailsBinding
import com.mmrbd.starwarsexplorer.presentation.details.contract.CharacterDetailsContract

class CharacterDetailsFragment :
    BaseFragment<CharacterDetailsContract.State, FragmentCharacterDetailsBinding>(
        FragmentCharacterDetailsBinding::inflate
    ) {


    private val args: CharacterDetailsFragmentArgs by navArgs()

    override val model: CharacterDetailsViewModel by viewModels()

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun FragmentCharacterDetailsBinding.initialiseView(savedInstanceState: Bundle?) {
        with(args.CharacterEntity) {
            tvName.text = name
            tvGender.text = getString(R.string.gender, gender)
            tvDOB.text = getString(R.string.dob, birthYear)
            tvHeight.text = getString(R.string.height, height)
            tvMass.text = getString(R.string.mass, mass)
            tvHairColor.text = getString(R.string.hair_color, hairColor)
            tvSkinColor.text = getString(R.string.skin_color, skinColor)
            tvEyeColor.text = getString(R.string.eye_color, eyeColor)
        }

    }

    override fun FragmentCharacterDetailsBinding.render(viewState: CharacterDetailsContract.State) {

    }
}