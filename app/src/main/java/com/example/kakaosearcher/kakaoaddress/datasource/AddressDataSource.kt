package com.example.kakaosearcher.kakaoaddress.datasource

import com.example.kakaosearcher.network.retrofit.RetrofitCallBack
import io.reactivex.disposables.Disposable

interface AddressDataSource<T>{

    fun getAddress(
        query: String?,
        retrofitCallBack: RetrofitCallBack<T>
    ):Disposable

}