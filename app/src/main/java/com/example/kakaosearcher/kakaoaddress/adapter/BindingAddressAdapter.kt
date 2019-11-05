package com.example.kakaosearcher.kakaoaddress.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kakaosearcher.kakaoaddress.model.response.AddressModel

@Suppress("UNCHECKED_CAST")
@BindingAdapter("listData")
fun setRecyclerViewProperties(recyclerView: RecyclerView, items: List<AddressModel>?) {
    (recyclerView.adapter as? AddressAdapter)?.run {
        setListData(items)
        notifyDataSetChanged()
    }
}