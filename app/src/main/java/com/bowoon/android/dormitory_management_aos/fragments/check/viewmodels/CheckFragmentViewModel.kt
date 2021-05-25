package com.bowoon.android.dormitory_management_aos.fragments.check.viewmodels

import androidx.lifecycle.MutableLiveData
import com.bowoon.android.dormitory_management_aos.base.BaseViewModel
import com.bowoon.android.dormitory_management_aos.models.CheckData

class CheckFragmentViewModel : BaseViewModel() {
    val checkList = MutableLiveData<CheckData>(CheckData())
    val showRoomCheckDialog = MutableLiveData<Int>()
}