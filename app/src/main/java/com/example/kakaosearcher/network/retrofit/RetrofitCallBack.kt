package com.example.kakaosearcher.network.retrofit

import retrofit2.Response

class RetrofitCallBack<T>(
    private val retrofitListener: RetrofitListener<T>
) {

    fun onResponse(
        response: Response<T>
    ) {
        val responseModel = response.body()
        if (responseModel == null) {
            retrofitListener.onFail(response.message())
            return
        }
        if (hasReissuedAccessToken()) {
            retrofitListener.onReissuedAccessToken()
            return
        }
        retrofitListener.onSuccess(responseModel)
    }

    fun onFailure(
        t: Throwable
    ) = retrofitListener.onNetworkError(t.message ?: "")

    /**
     * 토큰 만료체크 로직 구현 필요
     */
    private fun hasReissuedAccessToken(): Boolean = false

}