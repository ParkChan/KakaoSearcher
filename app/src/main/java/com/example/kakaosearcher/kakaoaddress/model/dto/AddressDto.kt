package com.example.kakaosearcher.kakaoaddress.model.dto

import com.example.kakaosearcher.kakaoaddress.model.AddressModel
import com.example.kakaosearcher.kakaoaddress.model.MetaModel
import com.google.gson.annotations.SerializedName

class AddressDto(
    @SerializedName("documents")
    val addressList: List<AddressModel>,

    @SerializedName("meta")
    val metaModel: MetaModel
)