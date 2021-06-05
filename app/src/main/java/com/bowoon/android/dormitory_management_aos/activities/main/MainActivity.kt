package com.bowoon.android.dormitory_management_aos.activities.main

import android.os.Bundle
import androidx.navigation.ui.setupActionBarWithNavController
import com.bowoon.android.dormitory_management_aos.R
import com.bowoon.android.dormitory_management_aos.activities.main.viewmodel.MainActivityViewModel
import com.bowoon.android.dormitory_management_aos.base.DataBindingActivityWithViewModel
import com.bowoon.android.dormitory_management_aos.base.navGraphIds
import com.bowoon.android.dormitory_management_aos.base.userType
import com.bowoon.android.dormitory_management_aos.component.navigation.setupWithNavController
import com.bowoon.android.dormitory_management_aos.databinding.ActivityMainBinding
import com.bowoon.android.dormitory_management_aos.models.UserType
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : DataBindingActivityWithViewModel<ActivityMainBinding, MainActivityViewModel>
    (R.layout.activity_main, MainActivityViewModel::class.java) {

    companion object {
        val TAG = MainActivity::class.simpleName ?: "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()

        binding.apply {
            lifecycleOwner = this@MainActivity
        }
        lifecycle.addObserver(activityVM)

        initLiveData()
        initBinding()
    }

    override fun initLiveData() {
        activityVM.currentNavController?.observe(this) { navController ->
            setupActionBarWithNavController(navController)
        }
    }

    override fun initBinding() {
        if (userType == UserType.ADMIN || userType == UserType.WORKING_SCHOLARSHIP) {
            binding.bnvBottomFooter.inflateMenu(R.menu.admin_bottom_footer)
        } else {
            binding.bnvBottomFooter.inflateMenu(R.menu.normal_bottom_footer)
        }

        binding.bnvBottomFooter.setupWithNavController(navGraphIds?.getGraphList() ?: mutableListOf(), supportFragmentManager, binding.fcvMainView.id, intent)
    }

    override fun onSupportNavigateUp(): Boolean {
        return activityVM.currentNavController?.value?.navigateUp() ?: false
    }
}