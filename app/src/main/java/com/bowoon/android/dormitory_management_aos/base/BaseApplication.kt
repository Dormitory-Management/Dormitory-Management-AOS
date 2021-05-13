package com.bowoon.android.dormitory_management_aos.base

import android.app.Application
import com.bowoon.android.dormitory_management_aos.component.navigation.NavigationGraphImpl

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        navGraphIds = NavigationGraphImpl()
    }
}

var navGraphIds: NavigationGraphImpl? = null