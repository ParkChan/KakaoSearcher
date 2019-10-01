package com.example.kakaosearcher.network.retrofit

class RetrofitCallBack<T>(
    private val retrofitListener: RetrofitListener<T>
) {

    fun onResponse(responseData: T) {
        if (responseData == null) {
            retrofitListener.onFail("responseData is null")
            return
        }
        if (hasReissuedAccessToken()) {
            retrofitListener.onReissuedAccessToken()
            return
        }
        retrofitListener.onSuccess(responseData)
    }

    fun onFailure(
        t: Throwable
    ) = retrofitListener.onNetworkError(t)

    /**
     * 토큰 만료체크 로직 구현 필요
     */
    private fun hasReissuedAccessToken(): Boolean = false

}