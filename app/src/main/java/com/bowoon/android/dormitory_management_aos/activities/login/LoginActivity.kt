package com.bowoon.android.dormitory_management_aos.activities.login

import android.content.Intent
import android.os.Bundle
import com.bowoon.android.common.log.Log
import com.bowoon.android.common.utils.showShortSnackbar
import com.bowoon.android.dormitory_management_aos.R
import com.bowoon.android.dormitory_management_aos.activities.login.viewmodel.LoginActivityViewModel
import com.bowoon.android.dormitory_management_aos.activities.main.MainActivity
import com.bowoon.android.dormitory_management_aos.base.BaseApplication
import com.bowoon.android.dormitory_management_aos.base.DataBindingActivityWithViewModel
import com.bowoon.android.dormitory_management_aos.base.userType
import com.bowoon.android.dormitory_management_aos.databinding.ActivityLoginBinding

class LoginActivity : DataBindingActivityWithViewModel<ActivityLoginBinding, LoginActivityViewModel>
    (R.layout.activity_login, LoginActivityViewModel::class.java) {
    companion object {
        val TAG = LoginActivity::class.simpleName ?: "LoginActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.apply {
            lifecycleOwner = this@LoginActivity
            vm = activityVM
        }
        lifecycle.addObserver(activityVM)

        initLiveData()
        initBinding()
    }

    override fun initLiveData() {

    }

    override fun initBinding() {
        binding.bLogin.setOnClickListener {
            val id = binding.etUserId.text.toString()
            val password = binding.etUserPassword.text.toString()

            if (id.isNotEmpty() && password.isNotEmpty()) {
                activityVM.doLogin(id,
                    password,
                    {
                        userType = it.userType
                        startActivity(Intent(this, MainActivity::class.java))
                        finish()
                    },
                    {
                        Log.e(it.message ?: "something wrong")
                        this.showShortSnackbar(binding.root, "???????????? ??????????????????.")
                    }
                )
            } else {
                this.showShortSnackbar(binding.root, "Check to ID and Password")
            }
        }
        binding.bCancel.setOnClickListener {
            finish()
        }
    }
}