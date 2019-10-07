package com.example.kakaosearcher.kakaoaddress.api

import com.example.kakaosearcher.kakaoaddress.model.dto.AddressDto
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiAddress {
    @GET("/v2/local/search/address.json")
    fun getAddress(
        @Query("query") query: String,
        @Query("page") page: Int = 1,
        @Query("size") size: Int = 30
    ): Single<AddressDto>
}