package com.example.kakaosearcher.common

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kakaosearcher.kakaoaddress.adapter.AddressAdapter
import com.example.kakaosearcher.kakaoaddress.model.data.AddressData

@Suppress("UNCHECKED_CAST")
@BindingAdapter("data")
fun setRecyclerViewProperties(recyclerView: RecyclerView, items: List<AddressData>?) {
    (recyclerView.adapter as? AddressAdapter)?.run {
        setData(items)
        notifyDataSetChanged()
    }
}