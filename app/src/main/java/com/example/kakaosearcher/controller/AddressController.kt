package com.example.kakaosearcher.controller

import com.example.kakaosearcher.network.model.resmodel.AddressModel
import com.example.kakaosearcher.network.retrofit.RetrofitCallBack
import com.example.kakaosearcher.network.retrofit.RetrofitListener
import com.example.kakaosearcher.network.service.AddressService

class AddressController{

    fun requestAddress(
        query: String?,
        listener: RetrofitListener<List<AddressModel>>
    ) {
        AddressService()
            .getAddressService()
            .getAddress(query = "$query")
            .enqueue(RetrofitCallBack(listener))
    }
}