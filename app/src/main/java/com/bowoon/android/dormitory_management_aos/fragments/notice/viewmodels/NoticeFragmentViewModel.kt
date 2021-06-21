package com.bowoon.android.dormitory_management_aos.fragments.notice.viewmodels

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import com.bowoon.android.dormitory_management_aos.base.BaseViewModel
import com.bowoon.android.dormitory_management_aos.models.NoticeData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NoticeFragmentViewModel @Inject constructor(

) : BaseViewModel(), LifecycleObserver {
    val noticeList = MutableLiveData<NoticeData>(NoticeData())
}