package com.example.kakaosearcher.kakaoaddress.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kakaosearcher.kakaoaddress.model.data.AddressData

@Suppress("UNCHECKED_CAST")
@BindingAdapter("listData")
fun setRecyclerViewProperties(recyclerView: RecyclerView, items: List<AddressData>?) {
    (recyclerView.adapter as? AddressAdapter)?.run {
        setListData(items)
        notifyDataSetChanged()
    }
}