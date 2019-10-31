package com.example.kakaosearcher.kakaoaddress.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kakaosearcher.common.BaseViewModel
import com.example.kakaosearcher.kakaoaddress.model.dto.AddressDto
import com.example.kakaosearcher.kakaoaddress.model.response.AddressModel
import com.example.kakaosearcher.kakaoaddress.repository.AddressRepository
import com.example.kakaosearcher.network.retrofit.CallBackListener


class AddressViewModel(private val addressRepository: AddressRepository) : BaseViewModel() {

    private val _addressList = MutableLiveData<List<AddressModel>>()
    val addressList: LiveData<List<AddressModel>>
        get() = _addressList

    private val _throwable = MutableLiveData<Throwable>()
    val throwable: LiveData<Throwable>
        get() = _throwable

    private fun searchAddress(query: String) {
        compositeDisposable.add(
            addressRepository.getAddress(
                query,
                object : CallBackListener<AddressDto> {
                    override fun onSuccess(responseData: AddressDto) {
                        _addressList.value = responseData.addressList
                    }

                    override fun onFail(t: Throwable) {
                        _throwable.value = t
                    }
                }
            )
        )
    }

    fun onClickSearch(query: String) {
        searchAddress(query)
    }
}