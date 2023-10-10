package com.mmrbd.starwarsexplorer.presentation.planet.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mmrbd.starwarsexplorer.base.adapters.BaseListAdapter
import com.mmrbd.starwarsexplorer.base.adapters.BindingViewHolder
import com.mmrbd.starwarsexplorer.databinding.ItemCharacterBinding
import com.mmrbd.starwarsexplorer.databinding.ItemPlanetBinding
import com.mmrbd.starwarsexplorer.domain.entities.CharacterEntity
import com.mmrbd.starwarsexplorer.domain.entities.PlanetEntity
import com.mmrbd.starwarsexplorer.presentation.home.adapter.CharacterAdapter

class PlanetAdapter(private val onItemClickListener: (PlanetEntity) -> Unit) :
    BaseListAdapter<PlanetEntity, PlanetAdapter.PlanetViewHolder>() {
    class PlanetViewHolder(
        parent: ViewGroup,
        private val onItemClickListener: (PlanetEntity) -> Unit
    ) :
        BindingViewHolder<PlanetEntity, ItemPlanetBinding>(
            ItemPlanetBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ),
                parent,
                false
            )
        ) {

        private lateinit var item: PlanetEntity
        override fun ItemPlanetBinding.initializeView() {
            itemView.setOnClickListener { onItemClickListener(item) }
        }

        override fun ItemPlanetBinding.render(item: PlanetEntity) {
            this@PlanetViewHolder.item = item
            tvName.text = item.name
            tvDiameter.text = "Diameter: ${item.diameter}"
            tvPopulation.text = "Population: ${item.population}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanetViewHolder =
        PlanetViewHolder(
            parent, onItemClickListener
        )
}