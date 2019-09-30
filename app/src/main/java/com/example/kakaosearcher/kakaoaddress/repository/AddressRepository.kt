package com.example.kakaosearcher.kakaoaddress.repository

import com.example.kakaosearcher.kakaoaddress.datasource.AddressDataSource
import com.example.kakaosearcher.kakaoaddress.model.resmodel.dto.AddressDto
import com.example.kakaosearcher.network.retrofit.RetrofitListener

class AddressRepository(
    private val addressDataSource: AddressDataSource
) : AddressDataSource {

    override fun getAddress(
        query: String?,
        listener: RetrofitListener<AddressDto>
    ) {
        addressDataSource.getAddress(query, listener)
    }
}