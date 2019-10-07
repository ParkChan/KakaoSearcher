package com.example.kakaosearcher.kakaoaddress.datasource

import com.example.kakaosearcher.kakaoaddress.model.dto.AddressDto
import com.example.kakaosearcher.kakaoaddress.service.AddressService
import com.example.kakaosearcher.network.retrofit.CallBackListener
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class AddressDataSourceImpl : AddressDataSource<AddressDto> {

    override fun getAddress(
        query: String?,
        callBackListener: CallBackListener<AddressDto>
    ): Disposable = AddressService()
        .getAddressService()
        .getAddress(query = "$query")
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
            callBackListener.onSuccess(it)
        }, {
            callBackListener.onFail(it)
        })
}