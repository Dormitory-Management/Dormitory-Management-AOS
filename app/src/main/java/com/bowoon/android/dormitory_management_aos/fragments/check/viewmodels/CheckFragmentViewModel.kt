package com.bowoon.android.dormitory_management_aos.fragments.check.viewmodels

import androidx.lifecycle.MutableLiveData
import com.bowoon.android.common.log.Log
import com.bowoon.android.dormitory_management_aos.base.BaseViewModel
import com.bowoon.android.dormitory_management_aos.base.dormitoryApi
import com.bowoon.android.dormitory_management_aos.base.networkConnection
import com.bowoon.android.dormitory_management_aos.models.Check
import com.bowoon.android.dormitory_management_aos.models.CheckData
import com.bowoon.android.dormitory_management_aos.models.SendCheckData

class CheckFragmentViewModel : BaseViewModel() {
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

        if (networkConnection) {
            dormitoryApi?.sendRoomCheck(
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
    }
}