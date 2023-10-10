package com.mmrbd.starwarsexplorer.base.adapters

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

abstract class BaseListAdapter<Item : ListItem, ViewHolder : BindingViewHolder<Item, out ViewBinding>>(
    diffUtilCallback: DiffUtil.ItemCallback<Item> = DiffUtilCallback()
) : ListAdapter<Item, ViewHolder>(
    diffUtilCallback
) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.render(getItem(position))

    override fun onViewRecycled(holder: ViewHolder) {
        holder.clear()
        super.onViewRecycled(holder)
    }
}

abstract class BindingViewHolder<Item, Binding : ViewBinding>(protected val binding: Binding) :
    RecyclerView.ViewHolder(binding.root) {

    init {
        initializeView()
    }

    fun render(item: Item) = binding.render(item)

    fun clear() = binding.clear()

    private fun initializeView() = binding.initializeView()

    open fun Binding.render(item: Item) {
        // Template
    }

    open fun Binding.initializeView() {
        // Template
    }

    open fun Binding.clear() {
        // Template
    }
}

open class DiffUtilCallback<T : ListItem> : DiffUtil.ItemCallback<T>() {

    override fun areItemsTheSame(oldItem: T, newItem: T) = oldItem.itemId == newItem.itemId

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: T, newItem: T) = oldItem == newItem
}

@Serializable
open class ListItem(
    @Contextual
    open val itemId: Any? = null
)
