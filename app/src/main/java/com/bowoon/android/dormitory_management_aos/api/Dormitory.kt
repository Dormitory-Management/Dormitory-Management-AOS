package com.bowoon.android.dormitory_management_aos.api

import com.bowoon.android.dormitory_management_aos.models.*
import io.reactivex.rxjava3.core.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.QueryMap

interface Dormitory {
    @POST("/dormitory/login.json")
    fun doLogin(@Body loginData: LoginData): Single<LoginResponse>

    @GET("/dormitory/today.json")
    fun getToday(): Single<TodayData>

    @GET("/dormitory/notice.json")
    fun getNotice(): Single<NoticeData>

    @GET("/dormitory/check_200.json")
    fun getCheck(@QueryMap params: Map<String, String>): Single<CheckData>

    @POST("/dormitory/roomCheck.json")
    fun sendRoomCheck(@Body checkData: SendCheckData): Single<RoomCheckResponse>
}