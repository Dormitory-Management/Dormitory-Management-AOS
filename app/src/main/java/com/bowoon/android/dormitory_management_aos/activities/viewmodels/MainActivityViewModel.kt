package com.bowoon.android.dormitory_management_aos.activities.viewmodels

import androidx.lifecycle.MutableLiveData
import com.bowoon.android.dormitory_management_aos.base.BaseViewModel
import com.bowoon.android.dormitory_management_aos.models.Person

class MainActivityViewModel : BaseViewModel() {
    val personList = MutableLiveData<MutableList<Person>>()
}