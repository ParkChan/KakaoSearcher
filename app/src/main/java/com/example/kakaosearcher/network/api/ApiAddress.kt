package com.example.kakaosearcher.network.api

import com.example.kakaosearcher.kakaoaddress.model.resmodel.dto.AddressDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiAddress {
    @GET("/v2/local/search/address.json")
    fun getAddress(
        @Query("query") query: String,
        @Query("page") page: Int = 1,
        @Query("size") size: Int = 30
    ): Call<AddressDto>
}