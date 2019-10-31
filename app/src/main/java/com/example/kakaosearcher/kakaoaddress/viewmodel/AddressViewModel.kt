package com.example.kakaosearcher.kakaoaddress.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.kakaosearcher.common.BaseViewModel
import com.example.kakaosearcher.kakaoaddress.model.response.AddressModel
import com.example.kakaosearcher.kakaoaddress.model.dto.AddressDto
import com.example.kakaosearcher.kakaoaddress.repository.AddressRepository
import com.example.kakaosearcher.network.retrofit.CallBackListener


class AddressViewModel(private val addressRepository: AddressRepository) : BaseViewModel() {

    val addressList = MutableLiveData<List<AddressModel>>()
    val throwable = MutableLiveData<Throwable>()

    private fun searchAddress(query: String) {
        compositeDisposable.add(
            addressRepository.getAddress(
                query,
                object : CallBackListener<AddressDto> {
                    override fun onSuccess(responseData: AddressDto) {
                        responseData.addressList?.apply {
                            addressList.value = this
                        }
                    }

                    override fun onFail(t: Throwable) {
                        throwable.value = t
                    }
                }
            )
        )
    }

    fun onClickSearch(query: String) {
        searchAddress(query)
    }
}