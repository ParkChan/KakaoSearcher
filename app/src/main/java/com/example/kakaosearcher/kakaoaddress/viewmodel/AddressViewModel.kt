package com.example.kakaosearcher.kakaoaddress.viewmodel

import android.text.Editable
import android.text.TextWatcher
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kakaosearcher.kakaoaddress.model.AddressModel
import com.example.kakaosearcher.kakaoaddress.model.dto.AddressDto
import com.example.kakaosearcher.kakaoaddress.repository.AddressRepository
import com.example.kakaosearcher.network.retrofit.CallBackListener
import io.reactivex.disposables.CompositeDisposable


class AddressViewModel(private val addressRepository: AddressRepository) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    val addressList = MutableLiveData<List<AddressModel>>()
    val throwable = MutableLiveData<Throwable>()
    var inputText: String = ""

    override fun onCleared() {
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
        super.onCleared()
    }

    private fun searchAddress(query: String) {
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

    fun onClickSearch(query: String) {
        searchAddress(query)
    }

    val watcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            inputText = s.toString()
        }

        override fun afterTextChanged(s: Editable) {}
    }
}