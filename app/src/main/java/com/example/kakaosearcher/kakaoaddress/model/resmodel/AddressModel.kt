package com.example.kakaosearcher.kakaoaddress.model.resmodel

import com.google.gson.annotations.SerializedName

data class AddressModel(
    @SerializedName("address_name")
    val addressName: String
)