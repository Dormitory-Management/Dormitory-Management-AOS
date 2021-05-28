package com.bowoon.android.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

inline fun <reified T> createRetrofit(url: String? = null): T = Retrofit.Builder().apply {
    if (url.isNullOrEmpty()) {
        baseUrl(BuildConfig.INIT_API)
    } else {
        baseUrl(url)
    }
    client(createOkHttpClient())
    addConverterFactory(GsonConverterFactory.create())
    addCallAdapterFactory(RxJava3CallAdapterFactory.create())
}.build().create(T::class.java)

inline fun <reified T> createRetrofit(url: String? = null, converter: Converter.Factory, factory: CallAdapter.Factory): T = Retrofit.Builder().apply {
    if (url.isNullOrEmpty()) {
        baseUrl(BuildConfig.INIT_API)
    } else {
        baseUrl(url)
    }
    client(createOkHttpClient())
    addConverterFactory(converter)
    addCallAdapterFactory(factory)
}.build().create(T::class.java)

inline fun <reified T> createRetrofit(url: String? = null, okHttpClient: OkHttpClient, converter: Converter.Factory, factory: CallAdapter.Factory): T = Retrofit.Builder().apply {
    if (url.isNullOrEmpty()) {
        baseUrl(BuildConfig.INIT_API)
    } else {
        baseUrl(url)
    }
    client(okHttpClient)
    addConverterFactory(converter)
    addCallAdapterFactory(factory)
}.build().create(T::class.java)

fun createOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
    .addInterceptor(HttpLoggingInterceptor().apply { this.level = level })
    .build()