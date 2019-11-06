package com.example.kakaosearcher.kakaoaddress.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kakaosearcher.common.BaseViewModel
import com.example.kakaosearcher.kakaoaddress.model.data.AddressData
import com.example.kakaosearcher.kakaoaddress.model.mapper.mapToData
import com.example.kakaosearcher.kakaoaddress.model.response.AddressListModel
import com.example.kakaosearcher.kakaoaddress.repository.AddressRepository
import com.example.kakaosearcher.network.retrofit.CallBackListener


class AddressViewModel(private val addressRepository: AddressRepository) : BaseViewModel() {

    private val _addressList = MutableLiveData<List<AddressData>>()
    val addressList: LiveData<List<AddressData>>
        get() = _addressList

    private val _throwable = MutableLiveData<Throwable>()
    val throwable: LiveData<Throwable>
        get() = _throwable

    private fun searchAddress(query: String) {
        compositeDisposable.add(
            addressRepository.getAddress(
                query,
                object : CallBackListener<AddressListModel> {
                    override fun onSuccess(responseData: AddressListModel) {
                        responseData.mapToData().addressList.run {
                            _addressList.value = this
                        }
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