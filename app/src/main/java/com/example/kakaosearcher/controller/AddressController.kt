package com.example.kakaosearcher.controller

import com.example.kakaosearcher.network.model.resmodel.dto.AddressDto
import com.example.kakaosearcher.network.retrofit.RetrofitCallBack
import com.example.kakaosearcher.network.retrofit.RetrofitListener
import com.example.kakaosearcher.network.service.AddressService

class AddressController{

    fun requestAddress(
        query: String?,
        listener: RetrofitListener<AddressDto>
    ) {
        AddressService()
            .getAddressService()
            .getAddress(query = "$query")
            .enqueue(RetrofitCallBack(listener))
    }
}