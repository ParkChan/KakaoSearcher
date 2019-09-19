package com.example.kakaosearcher.network.model.resmodel

import com.google.gson.annotations.SerializedName

data class AddressModel(
    @SerializedName("market")
    val market: String? = null
) : BaseModel()