package com.example.kakaosearcher.kakaoaddress.model.mapper

import com.example.kakaosearcher.kakaoaddress.model.data.AddressData
import com.example.kakaosearcher.kakaoaddress.model.response.AddressModel

fun AddressModel.mapToData(): AddressData =
    AddressData(addressName = addressName ?: "")