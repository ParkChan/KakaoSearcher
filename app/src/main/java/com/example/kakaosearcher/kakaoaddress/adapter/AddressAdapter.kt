package com.example.kakaosearcher.kakaoaddress.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kakaosearcher.BR
import com.example.kakaosearcher.R
import com.example.kakaosearcher.common.BindableAdapter
import com.example.kakaosearcher.databinding.ItemAddressBinding
import com.example.kakaosearcher.kakaoaddress.model.data.AddressData

class AddressAdapter :
    RecyclerView.Adapter<AddressAdapter.AddressViewHolder>(),
    BindableAdapter<AddressData> {

    private val addressList: MutableList<AddressData> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddressViewHolder {
        return AddressViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_address,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AddressViewHolder, position: Int) {
        val item = addressList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = addressList.size

    override fun setData(items: List<AddressData>?) {
        if (items != null) {
            addressList.run {
                clear()
                addAll(items)
            }
        }
    }

    inner class AddressViewHolder(private val binding: ItemAddressBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: AddressData) {
            binding.setVariable(BR.addressData, item)
        }
    }

}