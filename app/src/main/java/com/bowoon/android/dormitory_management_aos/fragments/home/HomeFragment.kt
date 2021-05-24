package com.bowoon.android.dormitory_management_aos.fragments.home

import android.os.Bundle
import android.view.View
import com.bowoon.android.dormitory_management_aos.R
import com.bowoon.android.dormitory_management_aos.activities.viewmodels.MainActivityViewModel
import com.bowoon.android.dormitory_management_aos.base.DataBindingFragmentWithViewModel
import com.bowoon.android.dormitory_management_aos.databinding.FragmentMainBinding
import com.bowoon.android.dormitory_management_aos.fragments.home.viewmodels.HomeFragmentViewModel

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

        initLiveData()
        initBinding()
    }

    override fun initLiveData() {

    }

    override fun initBinding() {

    }
}