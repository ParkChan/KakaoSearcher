package com.example.kakaosearcher.network.service

import com.example.kakaosearcher.network.api.ApiAddress
import com.example.kakaosearcher.network.retrofit.RetrofitBuilder

class ApiAddressService {
    fun getApiAddressService(): ApiAddress = RetrofitBuilder().init(
        headerMap = mapOf("Authorization" to "KakaoAk f95d654b8a2afcc056a2acb80b870b10"
        ), cls = ApiAddress::class.java)
}