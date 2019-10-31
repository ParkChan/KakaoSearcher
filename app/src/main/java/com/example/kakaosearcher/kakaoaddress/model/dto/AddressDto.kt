package com.example.kakaosearcher.kakaoaddress.model.dto

import com.example.kakaosearcher.kakaoaddress.model.response.AddressModel
import com.google.gson.annotations.SerializedName

data class AddressDto(
    @SerializedName("documents")
    val addressList: List<AddressModel>?
)