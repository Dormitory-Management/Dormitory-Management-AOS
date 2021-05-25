package com.bowoon.android.dormitory_management_aos.fragments.check

import android.os.Bundle
import android.view.View
import com.bowoon.android.common.utils.readAssetsFile
import com.bowoon.android.dormitory_management_aos.R
import com.bowoon.android.dormitory_management_aos.activities.viewmodels.MainActivityViewModel
import com.bowoon.android.dormitory_management_aos.adapter.CheckAdapter
import com.bowoon.android.dormitory_management_aos.adapter.NoticeAdapter
import com.bowoon.android.dormitory_management_aos.base.DataBindingFragmentWithViewModel
import com.bowoon.android.dormitory_management_aos.databinding.FragmentCheckBinding
import com.bowoon.android.dormitory_management_aos.dialogs.RoomCheckDialog
import com.bowoon.android.dormitory_management_aos.fragments.check.viewmodels.CheckFragmentViewModel
import com.bowoon.android.dormitory_management_aos.models.CheckData
import com.bowoon.android.dormitory_management_aos.models.NoticeData

class CheckFragment : DataBindingFragmentWithViewModel<FragmentCheckBinding, CheckFragmentViewModel, MainActivityViewModel>
    (R.layout.fragment_check, CheckFragmentViewModel::class.java, MainActivityViewModel::class.java) {
    companion object {
        val TAG = CheckFragment::class.simpleName ?: "CheckFragment"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            lifecycleOwner = this@CheckFragment
            fragmentVM = this@CheckFragment.fragmentVM
            activityVM = this@CheckFragment.activityVM
        }
        lifecycle.addObserver(fragmentVM)

        initSampleData()
        initLiveData()
        initBinding()
    }

    private fun initSampleData() {
        requireContext().readAssetsFile<CheckData>("check.json").let {
            fragmentVM.checkList.value = it
        }
    }

    override fun initLiveData() {
        fragmentVM.checkList.observe(viewLifecycleOwner) {
            (binding.rvCheck.adapter as? CheckAdapter)?.let { adapter ->
                adapter.items = it.data
                adapter.notifyDataSetChanged()
            }
        }
        fragmentVM.showRoomCheckDialog.observe(viewLifecycleOwner) {
            RoomCheckDialog(fragmentVM.checkList.value?.data?.get(it)?.people, fragmentVM).show(childFragmentManager, TAG)
        }
    }

    override fun initBinding() {
        binding.rvCheck.adapter = CheckAdapter().also {
            it.fragmentVM = fragmentVM
        }
    }
}