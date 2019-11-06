package com.example.kakaosearcher.kakaoaddress.model.mapper

import com.example.kakaosearcher.kakaoaddress.model.response.AddressListData
import com.example.kakaosearcher.kakaoaddress.model.response.AddressListModel

fun AddressListModel.mapToData(): AddressListData =
    AddressListData(addressList = addressList?.map { it.mapToData() } ?: listOf())

