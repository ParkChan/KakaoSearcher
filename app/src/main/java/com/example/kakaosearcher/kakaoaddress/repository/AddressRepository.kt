package com.example.kakaosearcher.kakaoaddress.repository

import com.example.kakaosearcher.kakaoaddress.datasource.AddressDataSource
import com.example.kakaosearcher.kakaoaddress.datasource.AddressDataSourceImpl
import com.example.kakaosearcher.kakaoaddress.model.resmodel.dto.AddressDto
import com.example.kakaosearcher.network.retrofit.RetrofitCallBack
import com.example.kakaosearcher.network.retrofit.RetrofitListener
import com.example.kakaosearcher.network.service.AddressService

class AddressRepository private constructor(
    private val addressDataSource: AddressDataSource
): AddressDataSourceImpl{

    override fun getAddress(query: String?, listener: RetrofitListener<AddressDto>) {
        addressDataSource.getAddress(query, listener)
    }

    companion object {
        private var instance: AddressRepository? = null

        operator fun invoke(
            addressDataSource: AddressDataSource
        ): AddressRepository = instance ?: AddressRepository(addressDataSource)
            .apply { instance = this }
    }

}