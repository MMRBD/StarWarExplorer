package com.mmrbd.starwarsexplorer.presentation.starship.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mmrbd.starwarsexplorer.base.adapters.BaseListAdapter
import com.mmrbd.starwarsexplorer.base.adapters.BindingViewHolder
import com.mmrbd.starwarsexplorer.databinding.ItemStarshipBinding
import com.mmrbd.starwarsexplorer.domain.entities.StarshipEntity

class StarshipAdapter(private val onItemClickListener: (StarshipEntity) -> Unit) :
    BaseListAdapter<StarshipEntity, StarshipAdapter.StarshipViewHolder>() {
    class StarshipViewHolder(
        parent: ViewGroup,
        private val onItemClickListener: (StarshipEntity) -> Unit
    ) :
        BindingViewHolder<StarshipEntity, ItemStarshipBinding>(
            ItemStarshipBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ),
                parent,
                false
            )
        ) {

        private lateinit var item: StarshipEntity
        override fun ItemStarshipBinding.initializeView() {
            itemView.setOnClickListener { onItemClickListener(item) }
        }

        override fun ItemStarshipBinding.render(item: StarshipEntity) {
            this@StarshipViewHolder.item = item
            tvName.text = item.name
            tvModel.text = "Model: ${item.model}"
            tvManufacturer.text = "Manufacturer: ${item.manufacturer}"
            tvClass.text = "Class: ${item.starshipClass}"
            tvCost.text = "Cost: $${item.costInCredits}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StarshipViewHolder =
        StarshipViewHolder(
            parent, onItemClickListener
        )
}