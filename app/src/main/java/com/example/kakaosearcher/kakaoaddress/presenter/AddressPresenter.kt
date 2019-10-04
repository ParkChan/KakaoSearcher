package com.example.kakaosearcher.kakaoaddress.presenter

import com.example.kakaosearcher.kakaoaddress.model.resmodel.dto.AddressDto
import com.example.kakaosearcher.kakaoaddress.repository.AddressRepository
import com.example.kakaosearcher.network.retrofit.CallBackListener
import io.reactivex.disposables.CompositeDisposable

class AddressPresenter(
    private val addressView: AddressContract.View,
    private val addressRepository: AddressRepository
) : AddressContract.Presenter, CallBackListener<AddressDto> {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun searchAddress(query: String) {
        compositeDisposable.add(
            addressRepository.getAddress(
                query,
                this
            )
        )
    }

    override fun dispose() {
        compositeDisposable.dispose()
    }

    override fun onSuccess(responseData: AddressDto) =
        addressView.updateAddressList(responseData.addressList)

    override fun onFail(t: Throwable) = addressView.showErrorMesage(t.message.toString())


}