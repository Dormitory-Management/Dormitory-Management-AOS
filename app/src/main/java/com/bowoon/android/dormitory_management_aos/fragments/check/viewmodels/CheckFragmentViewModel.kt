package com.bowoon.android.dormitory_management_aos.fragments.check.viewmodels

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import com.bowoon.android.common.log.Log
import com.bowoon.android.dormitory_management_aos.api.DormitoryAPIImpl
import com.bowoon.android.dormitory_management_aos.base.BaseViewModel
import com.bowoon.android.dormitory_management_aos.models.Check
import com.bowoon.android.dormitory_management_aos.models.CheckData
import com.bowoon.android.dormitory_management_aos.models.SendCheckData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CheckFragmentViewModel @Inject constructor(
    private val dormitoryApi: DormitoryAPIImpl
) : BaseViewModel(), LifecycleObserver {
    val checkList = MutableLiveData(CheckData())
    val showRoomCheckDialog = MutableLiveData<Int>()
    var roomIndex = -1

    fun completeCheck() {
        val completeRoom = SendCheckData(
            mutableListOf(
                Check(
                    checkList.value?.data?.get(roomIndex)?.id,
                    checkList.value?.data?.get(roomIndex)?.roomNumber,
                    checkList.value?.data?.get(roomIndex)?.people
                )
            )
        )

        dormitoryApi.sendRoomCheck(
            compositeDisposable,
            null,
            completeRoom,
            {
                Log.d("${it.state} ${it.message}")
            },
            { e ->
                Log.d(e.message ?: "something wrong")
            }
        )
    }

    fun initSampleData(success: ((CheckData) -> Unit)? = null, error: ((Throwable) -> Unit)? = null) {
        dormitoryApi.getCheck(
            compositeDisposable,
            mapOf("currentTime" to "${System.currentTimeMillis()}"),
            { success?.invoke(it) },
            { error?.invoke(it) }
        )
    }
}