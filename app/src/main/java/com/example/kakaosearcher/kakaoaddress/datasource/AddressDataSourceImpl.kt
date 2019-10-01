package com.example.kakaosearcher.kakaoaddress.datasource

import com.example.kakaosearcher.kakaoaddress.model.resmodel.dto.AddressDto
import com.example.kakaosearcher.kakaoaddress.service.AddressService
import com.example.kakaosearcher.network.retrofit.RetrofitCallBack
import com.example.kakaosearcher.network.retrofit.RetrofitListener
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class AddressDataSourceImpl : AddressDataSource {
    override fun getAddress(
        query: String?,
        listener: RetrofitListener<AddressDto>,
        compositeDisposable: CompositeDisposable
    ) {
        compositeDisposable.add(
            AddressService()
                .getAddressService()
                .getAddress(query = "$query")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    RetrofitCallBack(listener).onResponse(it)
                }, {
                    RetrofitCallBack(listener).onFailure(it)
                })
        )
    }
}