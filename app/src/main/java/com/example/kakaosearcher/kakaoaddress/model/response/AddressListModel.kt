package com.example.kakaosearcher.kakaoaddress.model.response

import com.google.gson.annotations.SerializedName

data class AddressListModel(
    @SerializedName("documents")
    val addressList: List<AddressModel>? = null
)