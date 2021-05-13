package com.bowoon.android.dormitory_management_aos.fragments.check

import android.os.Bundle
import android.view.View
import com.bowoon.android.dormitory_management_aos.R
import com.bowoon.android.dormitory_management_aos.activities.viewmodels.MainActivityViewModel
import com.bowoon.android.dormitory_management_aos.base.DataBindingFragmentWithViewModel
import com.bowoon.android.dormitory_management_aos.databinding.FragmentCheckBinding
import com.bowoon.android.dormitory_management_aos.fragments.check.viewmodels.CheckFragmentViewModel

class CheckFragment : DataBindingFragmentWithViewModel<FragmentCheckBinding, CheckFragmentViewModel, MainActivityViewModel>
    (R.layout.fragment_check, CheckFragmentViewModel::class.java, MainActivityViewModel::class.java) {
    companion object {
        val TAG = CheckFragment::class.simpleName ?: "MainFragment"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            lifecycleOwner = this@CheckFragment
            fragmentVM = this@CheckFragment.fragmentVM
            activityVM = this@CheckFragment.activityVM
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