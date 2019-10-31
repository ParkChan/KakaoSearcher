package com.example.kakaosearcher.kakaoaddress.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kakaosearcher.BR
import com.example.kakaosearcher.R
import com.example.kakaosearcher.common.BindableAdapter
import com.example.kakaosearcher.databinding.ItemAddressBinding
import com.example.kakaosearcher.kakaoaddress.model.response.AddressModel

class AddressAdapter :
    RecyclerView.Adapter<AddressAdapter.AddressViewHolder>(),
    BindableAdapter<AddressModel> {

    private val addressList: MutableList<AddressModel> = mutableListOf()

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

    override fun setData(data: List<AddressModel>?) {
        data?.let {
            addressList.run {
                clear()
                addAll(it)
            }
        }
    }

    inner class AddressViewHolder(private val binding: ItemAddressBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: AddressModel) {
            binding.setVariable(BR.addressModel, item)
        }
    }

}