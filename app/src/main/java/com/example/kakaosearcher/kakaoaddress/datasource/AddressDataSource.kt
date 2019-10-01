package com.example.kakaosearcher.kakaoaddress.datasource

import com.example.kakaosearcher.kakaoaddress.model.resmodel.dto.AddressDto
import com.example.kakaosearcher.network.retrofit.RetrofitCallBack
import io.reactivex.disposables.CompositeDisposable

interface AddressDataSource<T>{

    fun getAddress(
        query: String?,
        retrofitCallBack: RetrofitCallBack<T>,
        compositeDisposable: CompositeDisposable
    )

}