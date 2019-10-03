package com.example.kakaosearcher.kakaoaddress.presenter

import com.example.kakaosearcher.common.BasePresenter
import com.example.kakaosearcher.common.BaseView
import com.example.kakaosearcher.kakaoaddress.model.resmodel.AddressModel

interface AddressContract{

    interface View : BaseView<Presenter> {
        fun updateAddressList(addressList: List<AddressModel>)
        fun showErrorMesage(msg: String)
    }

    interface Presenter : BasePresenter{
        fun searchAddress(query: String)
    }
}