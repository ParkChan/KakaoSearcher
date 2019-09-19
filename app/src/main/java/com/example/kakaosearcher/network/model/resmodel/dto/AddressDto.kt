package com.example.kakaosearcher.network.model.resmodel.dto

import com.example.kakaosearcher.network.model.resmodel.BaseModel
import com.example.kakaosearcher.network.model.resmodel.DocumentModel
import com.google.gson.annotations.SerializedName

data class AddressDto(
    @SerializedName("address_name")
    private val addressName: List<String>,
    private val dataModel: DocumentModel
) : BaseModel()