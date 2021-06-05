package com.bowoon.android.dormitory_management_aos.fragments.home

import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bowoon.android.common.log.Log
import com.bowoon.android.common.utils.dp
import com.bowoon.android.common.utils.readAssetsFile
import com.bowoon.android.common.utils.rxRunOnUiThread
import com.bowoon.android.dormitory_management_aos.R
import com.bowoon.android.dormitory_management_aos.activities.main.viewmodel.MainActivityViewModel
import com.bowoon.android.dormitory_management_aos.adapter.TodayAdapter
import com.bowoon.android.dormitory_management_aos.base.DataBindingFragmentWithViewModel
import com.bowoon.android.dormitory_management_aos.base.dormitoryApi
import com.bowoon.android.dormitory_management_aos.base.networkConnection
import com.bowoon.android.dormitory_management_aos.databinding.FragmentMainBinding
import com.bowoon.android.dormitory_management_aos.fragments.home.viewmodels.HomeFragmentViewModel
import com.bowoon.android.dormitory_management_aos.models.LoginResponse
import com.bowoon.android.dormitory_management_aos.models.TodayData
import com.bowoon.android.dormitory_management_aos.models.TodayList
import com.bowoon.android.dormitory_management_aos.models.UserType
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.core.Single

@AndroidEntryPoint
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
        if (networkConnection) {
            dormitoryApi?.getToday(
                fragmentVM.compositeDisposable,
                null,
                {
                    fragmentVM.today.value = it
                },
                {
                    Log.e(it.message ?: "something wrong")
                }
            )
        } else {
            Single
                .just(requireContext().readAssetsFile<TodayData>("today.json"))
                .rxRunOnUiThread()
                .subscribe(
                    {
                        fragmentVM.today.value = it
                    },
                    {
                        Log.e(it.message ?: "something wrong")
                    }
                )
        }
    }

    override fun initLiveData() {
        fragmentVM.today.observe(viewLifecycleOwner) {
            (binding.rvMain.adapter as? TodayAdapter)?.let { adapter->
                val mainItems = mutableListOf(TodayList(it.data?.title, it.data?.time))
                mainItems.addAll(it.data?.todayList ?: mutableListOf())
                adapter.items = mainItems
                adapter.notifyDataSetChanged()
            }
        }
    }

    override fun initBinding() {
        binding.rvMain.apply {
            adapter = TodayAdapter().also {
                it.fragmentVM = fragmentVM
            }
            addItemDecoration(object : RecyclerView.ItemDecoration() {
                val margin = 10.dp
                override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
                    val position = parent.getChildLayoutPosition(view)
                    val size = parent.adapter?.itemCount ?: 0
                    if (position in 0 .. size) {
                        when (position) {
                            fragmentVM.today.value?.data?.todayList?.lastIndex -> {
                                outRect.bottom = margin
                            }
                            else -> {
                                outRect.bottom = 0
                            }
                        }
                        outRect.top = margin
                        outRect.left = margin
                        outRect.right = margin
                    }
                }
            })
        }
    }
}