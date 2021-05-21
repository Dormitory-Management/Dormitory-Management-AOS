package com.bowoon.android.dormitory_management_aos.fragments.notice

import android.os.Bundle
import android.view.View
import com.bowoon.android.dormitory_management_aos.R
import com.bowoon.android.dormitory_management_aos.activities.viewmodels.MainActivityViewModel
import com.bowoon.android.dormitory_management_aos.adapter.NoticeAdapter
import com.bowoon.android.dormitory_management_aos.base.DataBindingFragmentWithViewModel
import com.bowoon.android.dormitory_management_aos.databinding.FragmentNoticeBinding
import com.bowoon.android.dormitory_management_aos.fragments.notice.viewmodels.NoticeFragmentViewModel
import com.bowoon.android.dormitory_management_aos.models.Notice

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
        fragmentVM.noticeList.observe(viewLifecycleOwner) {
            (binding.rvNotice.adapter as? NoticeAdapter)?.let { adapter ->
                adapter.items = mutableListOf(
                    Notice(0, "Hello, World! 1", "Hello, World! 1", System.currentTimeMillis(), "admin"),
                    Notice(0, "Hello, World! 2", "Hello, World! 2", System.currentTimeMillis(), "admin"),
                    Notice(0, "Hello, World! 3", "Hello, World! 3", System.currentTimeMillis(), "admin"),
                    Notice(0, "Hello, World! 4", "Hello, World! 4", System.currentTimeMillis(), "admin"),
                    Notice(0, "Hello, World! 5", "Hello, World! 5", System.currentTimeMillis(), "admin")
                )
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