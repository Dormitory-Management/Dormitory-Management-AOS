package com.bowoon.android.dormitory_management_aos.fragments.notice

import android.os.Bundle
import android.view.View
import com.bowoon.android.common.utils.fromJson
import com.bowoon.android.dormitory_management_aos.R
import com.bowoon.android.dormitory_management_aos.activities.viewmodels.MainActivityViewModel
import com.bowoon.android.dormitory_management_aos.adapter.NoticeAdapter
import com.bowoon.android.dormitory_management_aos.base.DataBindingFragmentWithViewModel
import com.bowoon.android.dormitory_management_aos.databinding.FragmentNoticeBinding
import com.bowoon.android.dormitory_management_aos.fragments.notice.viewmodels.NoticeFragmentViewModel
import com.bowoon.android.dormitory_management_aos.models.Notice
import com.google.gson.Gson
import java.util.prefs.Preferences

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
                adapter.items = requireContext().assets.open("notice.json").bufferedReader().use {
                    Gson().fromJson<MutableList<Notice>>(it.readText())
                }
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