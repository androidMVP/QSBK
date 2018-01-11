package com.mvp.comm.network

import android.util.Log
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Administrator on 2017/8/22 0022.
 */


object AppRetrofit {

    val HOST_URL = "http://192.168.1.122:8080/qsbk/"

    private lateinit var retrofit: Retrofit

    init {
        initRef()
    }

    private fun initRef() {
        val gson = GsonBuilder().create()
        val httpLoggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message -> Log.i("okhttp", message) })
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClient = OkHttpClient().newBuilder()
                .connectTimeout(10L, TimeUnit.SECONDS)
                .readTimeout(10L, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor).build()

        retrofit = Retrofit.Builder().baseUrl(HOST_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .build()

    }

    fun <T> getApiService(clazz: Class<T>): T {
        return retrofit.create(clazz)
    }

}