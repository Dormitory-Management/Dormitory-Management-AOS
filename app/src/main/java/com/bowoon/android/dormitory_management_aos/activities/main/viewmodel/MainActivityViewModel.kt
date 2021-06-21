package com.bowoon.android.dormitory_management_aos.activities.main.viewmodel

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import com.bowoon.android.dormitory_management_aos.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(

) : BaseViewModel(), LifecycleObserver {
    var currentNavController: MutableLiveData<NavController>? = null
    val onScrollChange = MutableLiveData<Boolean>()
}