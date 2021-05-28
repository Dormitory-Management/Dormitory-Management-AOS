package com.bowoon.android.dormitory_management_aos.base

import android.app.Application
import com.bowoon.android.dormitory_management_aos.api.DormitoryAPI
import com.bowoon.android.dormitory_management_aos.api.DormitoryAPIImpl
import com.bowoon.android.dormitory_management_aos.component.navigation.NavigationGraphImpl
import com.google.gson.Gson

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        navGraphIds = NavigationGraphImpl()
        dormitoryApi = DormitoryAPIImpl()
        gson = Gson()
    }
}

var navGraphIds: NavigationGraphImpl? = null
var dormitoryApi: DormitoryAPI? = null
var gson: Gson? = null