package com.example.kakaosearcher.kakaoaddress.datasource

import com.example.kakaosearcher.kakaoaddress.model.resmodel.dto.AddressDto
import com.example.kakaosearcher.kakaoaddress.service.AddressService
import com.example.kakaosearcher.network.retrofit.RetrofitCallBack
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class AddressDataSourceImpl : AddressDataSource<AddressDto> {
    override fun getAddress(
        query: String?,
        retrofitCallBack: RetrofitCallBack<AddressDto>,
        compositeDisposable: CompositeDisposable
    ) {
        compositeDisposable.add(
            AddressService()
                .getAddressService()
                .getAddress(query = "$query")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    retrofitCallBack.onResponse(it)
                }, {
                    retrofitCallBack.onFailure(it)
                })
        )
    }
}