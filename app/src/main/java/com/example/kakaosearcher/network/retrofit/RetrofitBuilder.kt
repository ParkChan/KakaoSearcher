package com.example.kakaosearcher.network.retrofit

import com.example.kakaosearcher.BuildConfig
import com.example.kakaosearcher.network.NETWORK_CONST_BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder {

    fun <T> init(
        baseUrl: String = NETWORK_CONST_BASE_URL,
        headerMap: Map<String, String>? = mapOf(),
        useRxJava: Boolean = false,
        cls: Class<T>
    ): T = getRetrofitBuilder(
        baseUrl,
        getOkHttpClient(headerMap),
        useRxJava
    ).create(cls)

    private fun getRetrofitBuilder(
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