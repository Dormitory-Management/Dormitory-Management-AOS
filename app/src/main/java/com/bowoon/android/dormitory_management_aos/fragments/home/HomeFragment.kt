package com.bowoon.android.dormitory_management_aos.fragments.home

import android.os.Bundle
import android.view.View
import com.bowoon.android.common.utils.readAssetsFile
import com.bowoon.android.dormitory_management_aos.R
import com.bowoon.android.dormitory_management_aos.activities.viewmodels.MainActivityViewModel
import com.bowoon.android.dormitory_management_aos.base.DataBindingFragmentWithViewModel
import com.bowoon.android.dormitory_management_aos.databinding.FragmentMainBinding
import com.bowoon.android.dormitory_management_aos.fragments.home.viewmodels.HomeFragmentViewModel
import com.bowoon.android.dormitory_management_aos.models.TodayData

class HomeFragment : DataBindingFragmentWithViewModel<FragmentMainBinding, HomeFragmentViewModel, MainActivityViewModel>
        (R.layout.fragment_main, HomeFragmentViewModel::class.java, MainActivityViewModel::class.java) {
    companion object {
        val TAG = HomeFragment::class.simpleName ?: "MainFragment"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            lifecycleOwner = this@HomeFragment
            fragmentVM = this@HomeFragment.fragmentVM
            activityVM = this@HomeFragment.activityVM
        }
        lifecycle.addObserver(fragmentVM)

        initSampleData()
        initLiveData()
        initBinding()
    }

    private fun initSampleData() {
        fragmentVM.today.value = requireContext().readAssetsFile<TodayData>("today.json")
    }

    override fun initLiveData() {
        fragmentVM.today.observe(viewLifecycleOwner) {
            binding.tvTodayCheck.text = it.data?.today ?: "오늘의 공지 없음"
        }
    }

    override fun initBinding() {

    }
}