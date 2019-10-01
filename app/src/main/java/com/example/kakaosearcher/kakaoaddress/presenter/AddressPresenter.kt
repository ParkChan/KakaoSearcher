package com.example.kakaosearcher.kakaoaddress.presenter

import com.example.kakaosearcher.kakaoaddress.model.resmodel.dto.AddressDto
import com.example.kakaosearcher.kakaoaddress.repository.AddressRepository
import com.example.kakaosearcher.network.retrofit.RetrofitListener
import io.reactivex.disposables.CompositeDisposable

class AddressPresenter(
    private val addressView: AddressContract.View,
    private val addressRepository: AddressRepository
) : AddressContract.Presenter {

    private val compositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }

    override fun searchAddress(query: String) {
        addressRepository.getAddress(
            query,
            object : RetrofitListener<AddressDto> {
                override fun onSuccess(responseData: AddressDto) {
                    addressView.updateAddressList(responseData.addressList)
                }

                override fun onReissuedAccessToken() {
                }

                override fun onFail(msg: String) {
                    addressView.showErrorMesage(msg)
                }

                override fun onNetworkError(msg: String) {
                    addressView.showErrorMesage(msg)
                }
            },
            compositeDisposable
        )
    }

    override fun compositeDisposableDispose() {
        compositeDisposable.dispose()
    }
}