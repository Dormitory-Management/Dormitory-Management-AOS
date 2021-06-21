package com.bowoon.android.dormitory_management_aos.fragments.home.viewmodels

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import com.bowoon.android.common.log.Log
import com.bowoon.android.dormitory_management_aos.api.DormitoryAPIImpl
import com.bowoon.android.dormitory_management_aos.base.BaseViewModel
import com.bowoon.android.dormitory_management_aos.models.TodayData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeFragmentViewModel @Inject constructor(
    private val dormitoryApi: DormitoryAPIImpl
) : BaseViewModel(), LifecycleObserver {
    val today = MutableLiveData<TodayData>()

    fun initSampleData(success: ((TodayData) -> Unit)? = null, error: ((Throwable) -> Unit)? = null) {
        dormitoryApi.getToday(
            compositeDisposable,
            null,
            {
                today.value = it
                success?.invoke(it)
            },
            {
                Log.e(it.message ?: "something wrong")
                error?.invoke(it)
            }
        )
    }
}