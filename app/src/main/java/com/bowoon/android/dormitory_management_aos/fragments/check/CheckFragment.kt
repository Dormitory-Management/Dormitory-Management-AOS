package com.bowoon.android.dormitory_management_aos.fragments.check

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import com.bowoon.android.common.log.Log
import com.bowoon.android.common.utils.readAssetsFile
import com.bowoon.android.common.utils.rxRunOnUiThread
import com.bowoon.android.dormitory_management_aos.R
import com.bowoon.android.dormitory_management_aos.activities.main.viewmodel.MainActivityViewModel
import com.bowoon.android.dormitory_management_aos.adapter.CheckAdapter
import com.bowoon.android.dormitory_management_aos.base.DataBindingFragmentWithViewModel
import com.bowoon.android.dormitory_management_aos.base.dormitoryApi
import com.bowoon.android.dormitory_management_aos.base.networkConnection
import com.bowoon.android.dormitory_management_aos.databinding.FragmentCheckBinding
import com.bowoon.android.dormitory_management_aos.dialogs.RoomCheckDialog
import com.bowoon.android.dormitory_management_aos.fragments.check.viewmodels.CheckFragmentViewModel
import com.bowoon.android.dormitory_management_aos.models.CheckData
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.core.Single
import java.net.HttpURLConnection

@AndroidEntryPoint
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
        if (networkConnection) {
            dormitoryApi?.getCheck(
                fragmentVM.compositeDisposable,
                mapOf("currentTime" to "${System.currentTimeMillis()}"),
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
        } else {
            Single
                .just(requireContext().readAssetsFile<CheckData>("check_200.json"))
                .rxRunOnUiThread()
                .subscribe(
                    {
                        fragmentVM.checkList.value = it
                        if (fragmentVM.checkList.value?.state == HttpURLConnection.HTTP_INTERNAL_ERROR) {
                            binding.tvErrorPage.isVisible = true
                            binding.rvCheck.isVisible = false
                        } else {
                            binding.tvErrorPage.isVisible = false
                            binding.rvCheck.isVisible = true
                        }
                    },
                    { e ->
                        Log.e(e.message ?: "something wrong")
                        binding.tvErrorPage.isVisible = true
                        binding.rvCheck.isVisible = false
                    }
                )
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