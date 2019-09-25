package com.example.kakaosearcher.kakaoaddress.repository

import com.example.kakaosearcher.kakaoaddress.model.resmodel.dto.AddressDto
import com.example.kakaosearcher.network.retrofit.RetrofitCallBack
import com.example.kakaosearcher.network.retrofit.RetrofitListener
import com.example.kakaosearcher.network.service.AddressService

class AddressRepository {

    fun getAddress(
        query: String?,
        listener: RetrofitListener<AddressDto>
    ) {
        AddressService()
            .getAddressService()
            .getAddress(query = "$query")
            .enqueue(RetrofitCallBack(listener))
    }
}