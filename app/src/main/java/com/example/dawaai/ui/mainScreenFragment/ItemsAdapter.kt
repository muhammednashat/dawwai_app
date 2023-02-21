package com.example.dawaai.ui.mainScreenFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.dawaai.data.models.Item
import com.example.dawaai.databinding.ItemViewBinding


class ItemsAdapter(private val clickListener: ItemsListener) :
    ListAdapter<Item, ItemsAdapter.PlayListViewHolder>(ItemDiffUtil()) {


    class PlayListViewHolder private constructor(val binding: ItemViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            item: Item, clickListener: ItemsListener
        ) {

            binding.item = item
            binding.clickListener = clickListener
            binding.executePendingBindings()

        }

        companion object {
            fun from(parent: ViewGroup): PlayListViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemViewBinding.inflate(layoutInflater, parent, false)

                return PlayListViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayListViewHolder {
        return PlayListViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: PlayListViewHolder, position: Int) {
        holder.bind(getItem(position), clickListener)
    }
}


class ItemDiffUtil() : DiffUtil.ItemCallback<Item>() {
    override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem == newItem
    }

}


class ItemsListener(private val clickListener: (item: Item) -> Unit) {

    fun onClick(item: Item) = clickListener(item)
}