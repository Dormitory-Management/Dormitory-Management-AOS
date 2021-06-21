package com.bowoon.android.dormitory_management_aos.fragments.notice.viewmodels

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import com.bowoon.android.common.log.Log
import com.bowoon.android.dormitory_management_aos.api.DormitoryAPIImpl
import com.bowoon.android.dormitory_management_aos.base.BaseViewModel
import com.bowoon.android.dormitory_management_aos.models.NoticeData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NoticeFragmentViewModel @Inject constructor(
    private val dormitoryApi: DormitoryAPIImpl
) : BaseViewModel(), LifecycleObserver {
    val noticeList = MutableLiveData<NoticeData>(NoticeData())

    fun initSampleData(success: ((NoticeData) -> Unit)? = null, error: ((Throwable) -> Unit)? = null) {
        dormitoryApi.getNotice(
            compositeDisposable,
            null,
            {
                noticeList.value = it
                success?.invoke(it)
            },
            {
                Log.e(it.message ?: "something wrong")
                error?.invoke(it)
            }
        )
    }
}