package com.bowoon.android.dormitory_management_aos.dialogs

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.bowoon.android.dormitory_management_aos.R
import com.bowoon.android.dormitory_management_aos.base.DataBindingDialogWithViewModel
import com.bowoon.android.dormitory_management_aos.databinding.DialogNetworkErrorBinding
import com.bowoon.android.dormitory_management_aos.dialogs.viewmodels.NetworkErrorDialogViewModel

class NetworkErrorDialog(
        private val message: String = "",
        private val confirmText: String = "확인",
        private val confirmCallback: (() -> Unit)? = null,
        private val dismissText: String = "취소",
        private val dismissCallback: (() -> Unit)? = null
) : DataBindingDialogWithViewModel<DialogNetworkErrorBinding, NetworkErrorDialogViewModel>
(R.layout.dialog_network_error, NetworkErrorDialogViewModel::class.java) {
    private val viewModel by viewModels<NetworkErrorDialogViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            lifecycleOwner = this@NetworkErrorDialog
            vm = viewModel
        }

        viewModel.init(message, confirmText, dismissText)

        initLiveData()
    }

    fun initLiveData() {
        viewModel.buttonClicked.observe(this) {
            if (it) {
                confirmCallback?.invoke()
                dismissAllowingStateLoss()
            } else {
                dismissCallback?.invoke()
                dismissAllowingStateLoss()
            }
        }
    }
}