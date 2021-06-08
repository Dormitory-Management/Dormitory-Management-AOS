package com.bowoon.android.dormitory_management_aos.api

import com.bowoon.android.dormitory_management_aos.models.*
import io.reactivex.rxjava3.core.Single
import retrofit2.http.*

interface Dormitory {
    @POST("/login")
    fun doLogin(@Url url: String, @Body loginData: LoginData): Single<LoginResponse>

    @GET("/today")
    fun getToday(@Url url: String): Single<TodayData>

    @GET("/notice")
    fun getNotice(@Url url: String): Single<NoticeData>

    @GET("/check")
    fun getCheck(@Url url: String, @QueryMap params: Map<String, String>): Single<CheckData>

    @POST("/roomCheck")
    fun sendRoomCheck(@Url url: String, @Body checkData: SendCheckData): Single<RoomCheckResponse>
}