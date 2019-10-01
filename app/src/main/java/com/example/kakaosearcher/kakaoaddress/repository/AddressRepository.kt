package com.example.kakaosearcher.kakaoaddress.repository

import com.example.kakaosearcher.kakaoaddress.datasource.AddressDataSource
import com.example.kakaosearcher.kakaoaddress.model.resmodel.dto.AddressDto
import com.example.kakaosearcher.network.retrofit.RetrofitCallBack
import com.example.kakaosearcher.network.retrofit.RetrofitListener
import io.reactivex.disposables.CompositeDisposable

class AddressRepository(
    private val addressDataSource: AddressDataSource<AddressDto>
) : AddressDataSource<AddressDto> {
    override fun getAddress(
        query: String?,
        retrofitCallBack: RetrofitCallBack<AddressDto>,
        compositeDisposable: CompositeDisposable
    ) = addressDataSource.getAddress(query, retrofitCallBack, compositeDisposable)
}