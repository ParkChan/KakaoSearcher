package com.example.kakaosearcher.network.service

import com.example.kakaosearcher.network.NETWORK_CONST_HEADER_AUTHOR_KEY
import com.example.kakaosearcher.network.NETWORK_CONST_HEADER_REST_API_KEY
import com.example.kakaosearcher.network.api.ApiAddress
import com.example.kakaosearcher.network.retrofit.RetrofitBuilder

class AddressService {
    fun getAddressService(): ApiAddress = RetrofitBuilder().init(
        headerMap = mapOf(NETWORK_CONST_HEADER_AUTHOR_KEY to NETWORK_CONST_HEADER_REST_API_KEY
        ), cls = ApiAddress::class.java)
}