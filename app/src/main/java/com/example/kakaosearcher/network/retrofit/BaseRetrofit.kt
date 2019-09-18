package com.example.kakaosearcher.network.retrofit

import com.example.kakaosearcher.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class BaseRetrofit{

    fun <T> getRetrofit(
        baseUrl: String,
        headerMap: Map<String, String>,
        cls: Class<T>
    ): T = getRetrofit(
        baseUrl,
        getOkHttpClient(headerMap),
        false
    ).create(cls)

//    fun <T> getRetrofitRx(baseUrl: String, headerMap: Map<String, String>, cls: Class<T>): T {
//        return getRetrofit(baseUrl, getOkHttpClient(headerMap), true).create(cls)
//    }
//
//    fun <T> getRetrofit(baseUrl: String, cls: Class<T>): T {
//        return getRetrofit(baseUrl, getOkHttpClient(null), false).create(cls)
//    }

    fun getRetrofit(
        baseUrl: String,
        okHttpClient: OkHttpClient,
        useRxJava: Boolean
    ): Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .also { baseUrl ->
            if (useRxJava) baseUrl.addCallAdapterFactory(
                RxJava2CallAdapterFactory.create()
            )
        }
        .client(okHttpClient)
        .build()

    private fun getOkHttpClient(headerMap: Map<String, String>?): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()
        okHttpClient.addInterceptor { chain ->
            val requestBuilder = chain.request().newBuilder()
            headerMap?.apply {
                for ((key, value) in this) {
                    requestBuilder.addHeader(key, value)
                }
            }
            chain.proceed(requestBuilder.build())
        }
        okHttpClient.addInterceptor(getLoggingInterface())
        return okHttpClient.build()
    }

    private fun getLoggingInterface(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(
            if (BuildConfig.DEBUG)
                HttpLoggingInterceptor.Level.BODY
            else
                HttpLoggingInterceptor.Level.NONE
        )
    }

}