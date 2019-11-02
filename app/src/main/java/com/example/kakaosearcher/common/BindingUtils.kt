package com.example.kakaosearcher.common

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

@Suppress("UNCHECKED_CAST")
@BindingAdapter("data")
fun <T> setRecyclerViewProperties(recyclerView: RecyclerView, items: List<T>?) {
    if (recyclerView.adapter is BindableAdapter<*>) {
        recyclerView.adapter?.run {
            (this as BindableAdapter<T>).setData(items)
            notifyDataSetChanged()
        }
    }
}
