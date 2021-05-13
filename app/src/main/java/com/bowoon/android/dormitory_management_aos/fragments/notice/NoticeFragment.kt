package com.bowoon.android.dormitory_management_aos.fragments.notice

import android.os.Bundle
import android.view.View
import com.bowoon.android.dormitory_management_aos.R
import com.bowoon.android.dormitory_management_aos.activities.viewmodels.MainActivityViewModel
import com.bowoon.android.dormitory_management_aos.base.DataBindingFragmentWithViewModel
import com.bowoon.android.dormitory_management_aos.databinding.FragmentNoticeBinding
import com.bowoon.android.dormitory_management_aos.fragments.notice.viewmodels.NoticeFragmentViewModel

class NoticeFragment : DataBindingFragmentWithViewModel<FragmentNoticeBinding, NoticeFragmentViewModel, MainActivityViewModel>
    (R.layout.fragment_notice, NoticeFragmentViewModel::class.java, MainActivityViewModel::class.java) {
    companion object {
        val TAG = NoticeFragment::class.simpleName ?: "MainFragment"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            lifecycleOwner = this@NoticeFragment
            fragmentVM = this@NoticeFragment.fragmentVM
            activityVM = this@NoticeFragment.activityVM
        }
        lifecycle.addObserver(fragmentVM)

        initLiveData()
        initBinding()
    }

    override fun initLiveData() {

    }

    override fun initBinding() {

    }
}