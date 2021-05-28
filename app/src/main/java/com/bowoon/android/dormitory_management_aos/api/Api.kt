package com.bowoon.android.dormitory_management_aos.api

import com.bowoon.android.network.createRetrofit

object Api {
    val dormitory: Dormitory by lazy { createRetrofit() }
}