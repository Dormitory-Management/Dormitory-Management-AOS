package com.bowoon.android.dormitory_management_aos.fragments.notice

import android.os.Bundle
import android.view.View
import com.bowoon.android.dormitory_management_aos.R
import com.bowoon.android.dormitory_management_aos.activities.main.viewmodel.MainActivityViewModel
import com.bowoon.android.dormitory_management_aos.adapter.NoticeAdapter
import com.bowoon.android.dormitory_management_aos.base.DataBindingFragmentWithViewModel
import com.bowoon.android.dormitory_management_aos.databinding.FragmentNoticeBinding
import com.bowoon.android.dormitory_management_aos.fragments.notice.viewmodels.NoticeFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoticeFragment : DataBindingFragmentWithViewModel<FragmentNoticeBinding, NoticeFragmentViewModel, MainActivityViewModel>
    (R.layout.fragment_notice, NoticeFragmentViewModel::class.java, MainActivityViewModel::class.java) {
    companion object {
        val TAG = NoticeFragment::class.simpleName ?: "NoticeFragment"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            lifecycleOwner = this@NoticeFragment
            fragmentVM = this@NoticeFragment.fragmentVM
            activityVM = this@NoticeFragment.activityVM
        }
        lifecycle.addObserver(fragmentVM)

        fragmentVM.initSampleData()
        initLiveData()
        initBinding()
    }

    override fun initLiveData() {
        fragmentVM.noticeList.observe(viewLifecycleOwner) {
            (binding.rvNotice.adapter as? NoticeAdapter)?.let { adapter ->
                adapter.items = it.data
                adapter.notifyDataSetChanged()
            }
        }
    }

    override fun initBinding() {
        binding.rvNotice.adapter = NoticeAdapter().also {
            it.fragmentVM = fragmentVM
        }
    }
}