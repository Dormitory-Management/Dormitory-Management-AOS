package com.bowoon.android.dormitory_management_aos.fragments.notice.viewmodels

import androidx.lifecycle.MutableLiveData
import com.bowoon.android.dormitory_management_aos.base.BaseViewModel
import com.bowoon.android.dormitory_management_aos.models.Notice

class NoticeFragmentViewModel : BaseViewModel() {
    val noticeList = MutableLiveData<MutableList<Notice>>(mutableListOf())
}