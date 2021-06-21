package com.bowoon.android.dormitory_management_aos.fragments.home.viewmodels

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import com.bowoon.android.dormitory_management_aos.base.BaseViewModel
import com.bowoon.android.dormitory_management_aos.models.TodayData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeFragmentViewModel @Inject constructor(

) : BaseViewModel(), LifecycleObserver {
    val today = MutableLiveData<TodayData>()
}