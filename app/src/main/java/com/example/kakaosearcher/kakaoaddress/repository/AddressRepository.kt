package com.example.kakaosearcher.kakaoaddress.repository

import com.example.kakaosearcher.kakaoaddress.datasource.AddressDataSource
import com.example.kakaosearcher.kakaoaddress.model.resmodel.dto.AddressDto
import com.example.kakaosearcher.network.retrofit.CallBackListener

class AddressRepository(
    private val addressDataSource: AddressDataSource<AddressDto>
) : AddressDataSource<AddressDto> {

    override fun getAddress(
        query: String?,
        callBackListener: CallBackListener<AddressDto>
    ) = addressDataSource.getAddress(
        query,
        object : CallBackListener<AddressDto> {
            override fun onSuccess(responseData: AddressDto) {
                callBackListener.onSuccess(responseData)
            }

            override fun onFail(t: Throwable) {
                callBackListener.onFail(t)
            }
        }
    )
}