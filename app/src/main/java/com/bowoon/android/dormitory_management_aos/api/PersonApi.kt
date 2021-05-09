package com.bowoon.android.dormitory_management_aos.api

import com.bowoon.android.dormitory_management_aos.models.Persons
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface PersonApi {
    @GET("/api/")
    fun getUsers(@Query("results") results: Int): Single<Persons>
}