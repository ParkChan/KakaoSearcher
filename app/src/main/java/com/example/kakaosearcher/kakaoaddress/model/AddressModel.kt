package com.example.kakaosearcher.kakaoaddress.model

import com.google.gson.annotations.SerializedName

class AddressModel(
    @SerializedName("address_name")
    val addressName: String
)