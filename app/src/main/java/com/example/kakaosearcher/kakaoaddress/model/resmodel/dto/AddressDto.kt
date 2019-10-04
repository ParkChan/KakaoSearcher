package com.example.kakaosearcher.kakaoaddress.model.resmodel.dto

import com.example.kakaosearcher.kakaoaddress.model.resmodel.AddressModel
import com.example.kakaosearcher.kakaoaddress.model.resmodel.MetaModel
import com.google.gson.annotations.SerializedName

class AddressDto(
    @SerializedName("documents")
    val addressList: List<AddressModel>,

    @SerializedName("meta")
    val metaModel: MetaModel
)