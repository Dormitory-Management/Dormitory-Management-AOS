package com.bowoon.android.dormitory_management_aos.activities.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import com.bowoon.android.dormitory_management_aos.base.BaseViewModel

class MainActivityViewModel : BaseViewModel() {
    var currentNavController: MutableLiveData<NavController>? = null
}