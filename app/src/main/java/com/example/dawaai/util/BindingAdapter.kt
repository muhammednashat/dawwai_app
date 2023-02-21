package com.example.dawaai.util

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.dawaai.data.models.Item
import com.example.dawaai.ui.mainScreenFragment.ItemsAdapter


@BindingAdapter("listOfData")
fun bindRecyclerViewPlayList(recyclerView: RecyclerView, data: List<Item>) {
    val adapter = recyclerView.adapter as ItemsAdapter
    adapter.submitList(data)
}


@BindingAdapter("nameOfItem")
fun TextView.setNameOfItem(item: Item){
        text= item.name
    }





