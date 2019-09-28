package com.example.kakaosearcher.kakaoaddress.datasource

import com.example.kakaosearcher.kakaoaddress.model.resmodel.dto.AddressDto
import com.example.kakaosearcher.network.retrofit.RetrofitCallBack
import com.example.kakaosearcher.network.retrofit.RetrofitListener
import com.example.kakaosearcher.kakaoaddress.service.AddressService

class AddressDataSource : AddressDataSourceImpl {
    override fun getAddress(query: String?, listener: RetrofitListener<AddressDto>) {
        AddressService()
            .getAddressService()
            .getAddress(query = "$query")
            .enqueue(RetrofitCallBack(listener))
    }
}