package com.example.kakaosearcher.network.model.resmodel.dto

import com.example.kakaosearcher.network.model.resmodel.AddressModel
import com.example.kakaosearcher.network.model.resmodel.BaseModel
import com.example.kakaosearcher.network.model.resmodel.MetaModel
import com.google.gson.annotations.SerializedName

class AddressDto(
    @SerializedName("documents")
    val addressList: List<AddressModel>,

    @SerializedName("meta")
    val metaModel: MetaModel
) : BaseModel()