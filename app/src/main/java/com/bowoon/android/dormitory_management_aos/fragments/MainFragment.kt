package com.bowoon.android.dormitory_management_aos.fragments

import android.os.Bundle
import android.view.View
import com.bowoon.android.dormitory_management_aos.R
import com.bowoon.android.dormitory_management_aos.activities.viewmodels.MainActivityViewModel
import com.bowoon.android.dormitory_management_aos.adapter.PersonAdapter
import com.bowoon.android.dormitory_management_aos.base.DataBindingFragmentWithViewModel
import com.bowoon.android.dormitory_management_aos.databinding.FragmentMainBinding
import com.bowoon.android.dormitory_management_aos.dialogs.NetworkErrorDialog
import com.bowoon.android.dormitory_management_aos.fragments.viewmodels.MainFragmentViewModel
import com.bowoon.android.network.RxNetworkError

class MainFragment : DataBindingFragmentWithViewModel<FragmentMainBinding, MainFragmentViewModel, MainActivityViewModel>
        (R.layout.fragment_main, MainFragmentViewModel::class.java, MainActivityViewModel::class.java) {
    companion object {
        val TAG = MainFragment::class.simpleName ?: "MainFragment"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            lifecycleOwner = this@MainFragment
            fragmentVM = this@MainFragment.fragmentVM
            activityVM = this@MainFragment.activityVM
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