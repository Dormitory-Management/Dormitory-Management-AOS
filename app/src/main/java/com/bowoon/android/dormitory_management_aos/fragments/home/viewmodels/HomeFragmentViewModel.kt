package com.bowoon.android.dormitory_management_aos.fragments.home.viewmodels

import androidx.lifecycle.MutableLiveData
import com.bowoon.android.dormitory_management_aos.base.BaseViewModel
import com.bowoon.android.dormitory_management_aos.models.TodayData

class HomeFragmentViewModel : BaseViewModel() {
    val today = MutableLiveData<TodayData>()
}