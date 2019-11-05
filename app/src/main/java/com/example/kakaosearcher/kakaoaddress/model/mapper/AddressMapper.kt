package com.example.kakaosearcher.kakaoaddress.model.mapper

import com.example.kakaosearcher.kakaoaddress.model.dto.AddressDto
import com.example.kakaosearcher.kakaoaddress.model.response.AddressListData

fun AddressDto.mapToData(): AddressListData =
    AddressListData(addressList = addressList ?: listOf())