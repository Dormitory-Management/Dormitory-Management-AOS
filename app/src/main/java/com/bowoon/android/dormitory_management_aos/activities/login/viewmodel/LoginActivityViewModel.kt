package com.bowoon.android.dormitory_management_aos.activities.login.viewmodel

import com.bowoon.android.common.log.Log
import com.bowoon.android.dormitory_management_aos.base.BaseViewModel
import com.bowoon.android.dormitory_management_aos.base.dormitoryApi
import com.bowoon.android.dormitory_management_aos.base.networkConnection
import com.bowoon.android.dormitory_management_aos.models.LoginData
import com.bowoon.android.dormitory_management_aos.models.LoginResponse
import com.bowoon.android.dormitory_management_aos.models.UserType
import java.net.HttpURLConnection

class LoginActivityViewModel : BaseViewModel() {
    fun doLogin(id: String, password: String, onSuccess: ((LoginResponse) -> Unit)?, onError: ((Throwable) -> Unit)?) {
        if (networkConnection) {
            dormitoryApi?.doLogin(
                compositeDisposable,
                mapOf(),
                LoginData(id, password),
                {
                    if (it.state == HttpURLConnection.HTTP_OK) {
                        Log.d("Login Success")
                        onSuccess?.invoke(it)
                    } else if (it.state in 400..499) {
                        Log.e("Login Failed ${it.state}")
                    }
                },
                { e ->
                    Log.e("Login Failed")
                    onError?.invoke(e)
                }
            )
        } else {
            onSuccess?.invoke(LoginResponse(200, "success", UserType.WORKING_SCHOLARSHIP))
        }
    }
}