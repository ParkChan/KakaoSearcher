package com.example.kakaosearcher.network.retrofit

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitCallBack<T> constructor(val retrofitListener: RetrofitListener<T>) : Callback<T> {

    override fun onResponse(call: Call<T>, response: Response<T>) {

        val responseModel = response.body()

        if (responseModel == null) {
            retrofitListener?.let { it.onFail(response.message()) }
            return
        }

        if (hasReissuedAccessToken()) {
            retrofitListener?.let { it.onReissuedAccessToken() }
            return
        }

        retrofitListener?.let { it.onSuccess(responseModel) }

    }

    override fun onFailure(call: Call<T>, t: Throwable) {
        retrofitListener?.let { it.onNetworkError(t.message as String) }
    }

    /**
     * 토큰 만료체크
     */
    fun hasReissuedAccessToken(): Boolean = false
}