package com.bowoon.android.dormitory_management_aos.fragments.check.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.bowoon.android.dormitory_management_aos.base.BaseViewModel
import com.bowoon.android.dormitory_management_aos.base.gson
import com.bowoon.android.dormitory_management_aos.models.Check
import com.bowoon.android.dormitory_management_aos.models.CheckData

class CheckFragmentViewModel : BaseViewModel() {
    val checkList = MutableLiveData(CheckData())
    val showRoomCheckDialog = MutableLiveData<Int>()
    var roomIndex = -1

    fun completeCheck() {
        val completeRoom = CheckData(
            data = mutableListOf(
                Check(
                    checkList.value?.data?.get(roomIndex)?.id,
                    checkList.value?.data?.get(roomIndex)?.roomNumber,
                    checkList.value?.data?.get(roomIndex)?.people
                )
            )
        )

        val jsonString = gson?.toJson(completeRoom)
        Log.d("completeRoom", jsonString ?: "Gson is null!")
    }
}