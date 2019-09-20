package com.example.kakaosearcher.network.model.resmodel.dto

import com.example.kakaosearcher.network.model.resmodel.BaseModel
import com.example.kakaosearcher.network.model.resmodel.DocumentModel
import com.google.gson.annotations.SerializedName

data class AddressDto(
    @SerializedName("documents")
    private val dataModel: DocumentModel
) : BaseModel()