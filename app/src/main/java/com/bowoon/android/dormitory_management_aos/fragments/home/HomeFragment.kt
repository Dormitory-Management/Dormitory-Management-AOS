package com.bowoon.android.dormitory_management_aos.fragments.home

import android.os.Bundle
import android.view.View
import com.bowoon.android.dormitory_management_aos.R
import com.bowoon.android.dormitory_management_aos.activities.viewmodels.MainActivityViewModel
import com.bowoon.android.dormitory_management_aos.adapter.PersonAdapter
import com.bowoon.android.dormitory_management_aos.base.DataBindingFragmentWithViewModel
import com.bowoon.android.dormitory_management_aos.databinding.FragmentMainBinding
import com.bowoon.android.dormitory_management_aos.dialogs.NetworkErrorDialog
import com.bowoon.android.dormitory_management_aos.fragments.home.viewmodels.HomeFragmentViewModel
import com.bowoon.android.network.RxNetworkError

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
        fragmentVM.personList.observe(viewLifecycleOwner) { personList ->
            (binding.rvPersonList.adapter as? PersonAdapter)?.let { adapter ->
                adapter.items = personList
                adapter.notifyDataSetChanged()
            }
        }
        fragmentVM.showDialog.observe(viewLifecycleOwner) {
            NetworkErrorDialog(
                RxNetworkError.getErrorMessage(it),
                "새로고침",
                { fragmentVM.getData() },
                "취소",
                {}
            ).show(parentFragmentManager, TAG)
        }
    }

    override fun initBinding() {
        binding.rvPersonList.adapter = PersonAdapter().also {
            it.fragmentVM = fragmentVM
        }
    }
}