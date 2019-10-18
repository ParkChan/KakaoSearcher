package com.example.kakaosearcher.kakaoaddress.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kakaosearcher.kakaoaddress.model.AddressModel
import com.example.kakaosearcher.kakaoaddress.model.dto.AddressDto
import com.example.kakaosearcher.kakaoaddress.repository.AddressRepository
import com.example.kakaosearcher.network.retrofit.CallBackListener
import io.reactivex.disposables.CompositeDisposable

class AddressViewModel(private val addressRepository: AddressRepository) : ViewModel() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    val addressList = MutableLiveData<List<AddressModel>>()
    var throwable = MutableLiveData<Throwable>()

    fun searchAddress(query: String) {
        compositeDisposable.add(
            addressRepository.getAddress(
                query,
                object : CallBackListener<AddressDto> {
                    override fun onSuccess(responseData: AddressDto) {
                        addressList.value = responseData.addressList
                    }

                    override fun onFail(t: Throwable) {
                        throwable.value = t
                    }
                }
            )
        )
    }

    override fun onCleared() {
        if (compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
        super.onCleared()
    }
}