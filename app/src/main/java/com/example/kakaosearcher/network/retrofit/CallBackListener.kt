package com.example.kakaosearcher.network.retrofit

interface CallBackListener<T> {
    fun onSuccess(responseData: T)
    fun onFail(t: Throwable)
}