package com.mmrbd.starwarsexplorer.base.adapters

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.util.*

@SuppressWarnings("TooManyFunctions")
abstract class BaseRecyclerViewAdapter<T> : RecyclerView.Adapter<BaseViewHolder<T>>() {

    protected var listItems: ArrayList<T>? = ArrayList()
    var selectedItems: T? = null
    var onItemClickListeners: OnItemClickListener<T>? = null

    /**
     * set item selected
     *
     * @param item
     */
    @SuppressLint("NotifyDataSetChanged")
    fun setSelectedItem(item: T) {
        selectedItems = item
        notifyDataSetChanged()
    }

    /**
     * set item selected by position
     *
     * @param position
     */
    @SuppressWarnings("NotifyDataSetChanged")
    fun setSelectedItemPosition(position: Int) {
        selectedItems = listItems!![position]
        notifyDataSetChanged()
    }

    /**
     * get item from position
     *
     * @param position
     * @return
     */
    fun getItem(position: Int): T? {
        return if (listItems == null || listItems!!.isEmpty()) null else listItems!![position]
    }

    /**
     * Get all list of items
     *
     * @return items
     */
    fun getItems(): ArrayList<T>? {
        return listItems
    }

    /**
     * set list items
     *
     * @param items
     */
    @SuppressLint("NotifyDataSetChanged")
    fun setItems(items: ArrayList<T>?) {
        this.listItems?.clear()
        this.listItems?.addAll(items!!)
        notifyDataSetChanged()
    }

    /**
     * attach on item click listner
     *
     * @param onItemClickListener
     */
    fun setOnItemClickListener(onItemClickListener: OnItemClickListener<T>?) {
        this.onItemClickListeners = onItemClickListener
    }

    /**
     * update item at postion
     *
     * @param position
     * @param item
     */
    fun updateItemAt(position: Int, items: T) {
        listItems?.let { list ->
            if (position >= 0 && position < list.size) {
                list[position] = items
                notifyItemChanged(position)
            }
        }
    }

    /**
     * remove item from list
     *
     * @param item
     */
    @SuppressLint("NotifyDataSetChanged")
    fun removeItem(item: T) {
        val pos = listItems?.indexOf(item)
        listItems?.remove(item)
        if (pos != null) {
            if (pos >= 0) {
                notifyItemRemoved(pos)
            } else {
                notifyDataSetChanged()
            }
        }
    }
    /**
     * add items and clear previous list
     *
     * @param items
     * @param clearPrevious
     */
    /**
     * add item with clear previous list
     *
     * @param items
     */
    @SuppressLint("NotifyDataSetChanged")
    @JvmOverloads
    fun addItems(items: List<T>?, clearPrevious: Boolean = false) {
        if (clearPrevious) {
            this.listItems?.clear()
        }
        items?.let { this.listItems?.addAll(it) }
        notifyDataSetChanged()
    }

    /**
     * Add single item
     *
     * @param item
     */
    @SuppressLint("NotifyDataSetChanged")
    fun addItem(item: T) {
        listItems?.add(item)
        notifyDataSetChanged()
    }

    /**
     * Add item to position
     *
     * @param position
     * @param item
     */
    @SuppressLint("NotifyDataSetChanged")
    fun addItem(position: Int, item: T) {
        listItems?.add(position, item)
        notifyDataSetChanged()
    }

    /**
     * abstract method to create custom view holder
     */
    protected abstract fun createItemViewHolder(
        parent: ViewGroup?,
        viewType: Int
    ): BaseViewHolder<T>

    /**
     * abstract method to bind custom data
     */
    protected abstract fun bindItemViewHolder(holder: BaseViewHolder<T>?, position: Int)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T> {
        return createItemViewHolder(parent, viewType)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        bindItemViewHolder(holder, position)
    }

    override fun getItemCount(): Int {
        return listItems?.size ?: 0
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    val isEmpty: Boolean
        get() = listItems != null && listItems?.size == 0

    /**
     * remove item from list by position
     *
     * @param position
     */
    fun removeItem(position: Int) {
        if (position >= 0) {
            listItems!!.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    /**
     * remove item from list
     */
    @SuppressLint("NotifyDataSetChanged")
    fun removeAllItems() {
        listItems?.clear()
        listItems = null
        listItems = ArrayList()
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun clearAdapter() {
        listItems?.clear()
        notifyDataSetChanged()
    }

    interface OnItemClickListener<T> {
        fun onItemClicked(position: Int, item: T)
    }
}
