package com.example.kakaosearcher.kakaoaddress.model.response

import com.google.gson.annotations.SerializedName

data class AddressModel(
    @SerializedName("address_name")
    val addressName: String?
)