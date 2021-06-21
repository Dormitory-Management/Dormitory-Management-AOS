package com.bowoon.android.dormitory_management_aos.fragments.check

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import com.bowoon.android.common.log.Log
import com.bowoon.android.dormitory_management_aos.R
import com.bowoon.android.dormitory_management_aos.activities.main.viewmodel.MainActivityViewModel
import com.bowoon.android.dormitory_management_aos.adapter.CheckAdapter
import com.bowoon.android.dormitory_management_aos.api.DormitoryAPIImpl
import com.bowoon.android.dormitory_management_aos.base.DataBindingFragmentWithViewModel
import com.bowoon.android.dormitory_management_aos.databinding.FragmentCheckBinding
import com.bowoon.android.dormitory_management_aos.dialogs.RoomCheckDialog
import com.bowoon.android.dormitory_management_aos.fragments.check.viewmodels.CheckFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.net.HttpURLConnection
import javax.inject.Inject

@AndroidEntryPoint
class CheckFragment : DataBindingFragmentWithViewModel<FragmentCheckBinding, CheckFragmentViewModel, MainActivityViewModel>
    (R.layout.fragment_check, CheckFragmentViewModel::class.java, MainActivityViewModel::class.java) {
    companion object {
        val TAG = CheckFragment::class.simpleName ?: "CheckFragment"
    }

    @Inject
    lateinit var dormitoryApi: DormitoryAPIImpl

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            lifecycleOwner = this@CheckFragment
            fragmentVM = this@CheckFragment.fragmentVM
            activityVM = this@CheckFragment.activityVM
        }
        lifecycle.addObserver(fragmentVM)

        fragmentVM.initSampleData(
            {
                if (it.state == HttpURLConnection.HTTP_INTERNAL_ERROR) {
                    binding.tvErrorPage.isVisible = true
                    binding.rvCheck.isVisible = false
                } else {
                    binding.tvErrorPage.isVisible = false
                    binding.rvCheck.isVisible = true
                    fragmentVM.checkList.value = it
                }
            },
            {
                Log.e(it.message ?: "something wrong")
                binding.tvErrorPage.isVisible = true
                binding.rvCheck.isVisible = false
            }
        )
        initLiveData()
        initBinding()
    }

    override fun initLiveData() {
        fragmentVM.checkList.observe(viewLifecycleOwner) {
            (binding.rvCheck.adapter as? CheckAdapter)?.let { adapter ->
                adapter.items = it.data
                adapter.notifyDataSetChanged()
            }
        }
        fragmentVM.showRoomCheckDialog.observe(viewLifecycleOwner) {
            if (it != -1) {
                fragmentVM.roomIndex = it
                RoomCheckDialog(fragmentVM.checkList.value?.data?.get(it)?.people, fragmentVM).show(childFragmentManager, TAG)
            }
        }
    }

    override fun initBinding() {
        binding.rvCheck.adapter = CheckAdapter().also {
            it.fragmentVM = fragmentVM
        }
    }
}