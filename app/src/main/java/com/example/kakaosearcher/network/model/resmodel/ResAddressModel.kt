package com.example.kakaosearcher.network.model.resmodel

import com.google.gson.annotations.SerializedName

data class ResAddressModel(
    @SerializedName("market")
    val market: String? = null
) : ResBaseModel()