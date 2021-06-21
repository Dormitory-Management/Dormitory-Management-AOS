package com.bowoon.android.dormitory_management_aos.activities.login.viewmodel

import androidx.lifecycle.LifecycleObserver
import com.bowoon.android.common.log.Log
import com.bowoon.android.dormitory_management_aos.api.DormitoryAPIImpl
import com.bowoon.android.dormitory_management_aos.base.BaseViewModel
import com.bowoon.android.dormitory_management_aos.models.LoginData
import com.bowoon.android.dormitory_management_aos.models.LoginResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import java.net.HttpURLConnection
import javax.inject.Inject

@HiltViewModel
class LoginActivityViewModel @Inject constructor(
    private val dormitoryApi: DormitoryAPIImpl
) : BaseViewModel(), LifecycleObserver {
    fun doLogin(id: String, password: String, onSuccess: ((LoginResponse) -> Unit)?, onError: ((Throwable) -> Unit)?) {
        dormitoryApi.doLogin(
            compositeDisposable,
            null,
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
    }
}