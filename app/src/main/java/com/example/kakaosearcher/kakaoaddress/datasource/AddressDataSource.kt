package com.example.kakaosearcher.kakaoaddress.datasource

import com.example.kakaosearcher.network.retrofit.CallBackListener
import io.reactivex.disposables.Disposable

interface AddressDataSource<T> {

    fun getAddress(
        query: String?,
        callBackListener: CallBackListener<T>
    ): Disposable

}