package com.bowoon.android.dormitory_management_aos.api

import com.bowoon.android.dormitory_management_aos.models.TodayData
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Url

interface Dormitory {
    @GET
    fun getToday(@Url url: String): Single<TodayData>
}