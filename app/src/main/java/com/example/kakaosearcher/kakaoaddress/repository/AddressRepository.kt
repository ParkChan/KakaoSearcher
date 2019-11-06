package com.example.kakaosearcher.kakaoaddress.repository

import com.example.kakaosearcher.kakaoaddress.datasource.AddressDataSource
import com.example.kakaosearcher.kakaoaddress.model.response.AddressListModel
import com.example.kakaosearcher.network.retrofit.CallBackListener

class AddressRepository(
    private val addressListDataSource: AddressDataSource<AddressListModel>
) : AddressDataSource<AddressListModel> {

    override fun getAddress(
        query: String?,
        callBackListener: CallBackListener<AddressListModel>
    ) = addressListDataSource.getAddress(
        query,
        object : CallBackListener<AddressListModel> {
            override fun onSuccess(responseData: AddressListModel) {
                callBackListener.onSuccess(responseData)
            }

            override fun onFail(t: Throwable) {
                callBackListener.onFail(t)
            }
        }
    )
}