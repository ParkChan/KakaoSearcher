package com.example.kakaosearcher.kakaoaddress.model

import com.google.gson.annotations.SerializedName

data class MetaModel(
    @SerializedName("is_end")
    val isEnd: Boolean,

    @SerializedName("pageable_count")
    val pageableCount: Int,

    @SerializedName("total_count")
    val totalCount: Int
)