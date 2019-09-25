package com.example.kakaosearcher.kakaoaddress.presenter

import com.example.kakaosearcher.kakaoaddress.model.resmodel.AddressModel

interface AddressContract {

    interface View {
        fun updateAddressList(addressList: List<AddressModel>)
        fun showErrorMesage(msg: String)
    }

    interface Presenter {
        fun searchAddress(query: String)
    }
}