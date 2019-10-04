package com.example.kakaosearcher.kakaoaddress.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kakaosearcher.R
import com.example.kakaosearcher.kakaoaddress.model.resmodel.AddressModel

class AddressAdapter : RecyclerView.Adapter<AddressAdapter.ViewHolder>() {
    private var addressList: List<AddressModel>? = null

    fun setAddressList(addressList: List<AddressModel>) {
        this.addressList = addressList
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_address_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return addressList?.size ?: 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        addressList?.get(position)?.let { holder.bind(it) }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val addressText =
            itemView.findViewById<TextView>(R.id.tv_adapter_address_item_address)

        fun bind(addressModel: AddressModel) {
            addressText?.text = addressModel.addressName
        }
    }
}