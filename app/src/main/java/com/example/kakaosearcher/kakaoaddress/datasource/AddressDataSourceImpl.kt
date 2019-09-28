package com.example.kakaosearcher.kakaoaddress.datasource

import com.example.kakaosearcher.kakaoaddress.model.resmodel.dto.AddressDto
import com.example.kakaosearcher.network.retrofit.RetrofitListener

interface AddressDataSourceImpl {

    fun getAddress(
        query: String?,
        listener: RetrofitListener<AddressDto>
    )

}