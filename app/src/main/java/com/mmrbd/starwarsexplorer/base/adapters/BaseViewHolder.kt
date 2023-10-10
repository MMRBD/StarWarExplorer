package com.mmrbd.starwarsexplorer.base.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T>(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
    /**
     * implement this method to bind data of item to view
     *
     * @param item
     */
    abstract fun bind(item: T)
}
