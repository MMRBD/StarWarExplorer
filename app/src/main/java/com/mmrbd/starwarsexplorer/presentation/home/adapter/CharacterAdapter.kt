package com.mmrbd.starwarsexplorer.presentation.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mmrbd.starwarsexplorer.R
import com.mmrbd.starwarsexplorer.base.adapters.BaseListAdapter
import com.mmrbd.starwarsexplorer.base.adapters.BindingViewHolder
import com.mmrbd.starwarsexplorer.databinding.ItemCharacterBinding
import com.mmrbd.starwarsexplorer.domain.entities.CharacterEntity

class CharacterAdapter(private val onItemClickListener: (CharacterEntity) -> Unit) :
    BaseListAdapter<CharacterEntity, CharacterAdapter.CharacterViewHolder>() {
    class CharacterViewHolder(
        parent: ViewGroup,
        private val onItemClickListener: (CharacterEntity) -> Unit
    ) :
        BindingViewHolder<CharacterEntity, ItemCharacterBinding>(
            ItemCharacterBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ),
                parent,
                false
            )
        ) {

        private lateinit var item: CharacterEntity
        override fun ItemCharacterBinding.initializeView() {
            itemView.setOnClickListener { onItemClickListener(item) }
        }

        override fun ItemCharacterBinding.render(item: CharacterEntity) {
            this@CharacterViewHolder.item = item
            tvName.text = item.name
            tvGender.text = item.gender
            tvDOB.text = itemView.context.getString(R.string.dob, item.birthYear)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder =
        CharacterViewHolder(
            parent, onItemClickListener
        )
}