package com.bowoon.android.dormitory_management_aos.activities.login.viewmodel

import com.bowoon.android.common.log.Log
import com.bowoon.android.dormitory_management_aos.base.BaseViewModel
import com.bowoon.android.dormitory_management_aos.base.dormitoryApi
import com.bowoon.android.dormitory_management_aos.models.LoginData
import java.net.HttpURLConnection

class LoginActivityViewModel : BaseViewModel() {
    fun doLogin(id: String, password: String) {
        dormitoryApi?.doLogin(
            compositeDisposable,
            mapOf(),
            LoginData(id, password),
            {
                if (it.state == HttpURLConnection.HTTP_OK) {
                    Log.d("Login Success")
                } else if (it.state in 400 .. 499) {
                    Log.e("Login Failed ${it.state}")
                }
            },
            { Log.e("Login Failed") }
        )
    }
}