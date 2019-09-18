package com.example.kakaosearcher.network.retrofit

interface RetrofitListener<T> {
    fun onSuccess(responseData: T)
    fun onReissuedAccessToken()
    fun onFail(msg: String)
    fun onNetworkError(msg: String)
}