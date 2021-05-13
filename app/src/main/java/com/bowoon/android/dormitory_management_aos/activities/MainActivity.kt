package com.bowoon.android.dormitory_management_aos.activities

import android.os.Bundle
import androidx.navigation.ui.setupActionBarWithNavController
import com.bowoon.android.dormitory_management_aos.R
import com.bowoon.android.dormitory_management_aos.activities.viewmodels.MainActivityViewModel
import com.bowoon.android.dormitory_management_aos.base.DataBindingActivityWithViewModel
import com.bowoon.android.dormitory_management_aos.base.navGraphIds
import com.bowoon.android.dormitory_management_aos.component.navigation.setupWithNavController
import com.bowoon.android.dormitory_management_aos.databinding.ActivityMainBinding

class MainActivity : DataBindingActivityWithViewModel<ActivityMainBinding, MainActivityViewModel>
    (R.layout.activity_main, MainActivityViewModel::class.java) {

    companion object {
        val TAG = MainActivity::class.simpleName ?: "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initLiveData()
        initBinding()
    }

    override fun initLiveData() {
        activityVM.currentNavController?.observe(this) { navController ->
            setupActionBarWithNavController(navController)
        }
    }

    override fun initBinding() {
        binding.bnvBottomFooter.setupWithNavController(navGraphIds?.getGraphList() ?: mutableListOf(), supportFragmentManager, binding.fcvMainView.id, intent)
    }

    override fun onSupportNavigateUp(): Boolean {
        return activityVM.currentNavController?.value?.navigateUp() ?: false
    }
}