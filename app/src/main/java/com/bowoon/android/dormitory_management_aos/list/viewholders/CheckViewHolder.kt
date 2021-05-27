package com.bowoon.android.dormitory_management_aos.list.viewholders

import com.bowoon.android.common.utils.shotOne
import com.bowoon.android.dormitory_management_aos.base.BaseViewHolder
import com.bowoon.android.dormitory_management_aos.databinding.ViewholderCheckBinding
import com.bowoon.android.dormitory_management_aos.fragments.check.viewmodels.CheckFragmentViewModel
import com.bowoon.android.dormitory_management_aos.models.Check

class CheckViewHolder(
    private val binding: ViewholderCheckBinding,
    private val fragmentVM: CheckFragmentViewModel
) : BaseViewHolder(binding.root) {
    fun bind(item: Check) {
        binding.vh = this
        binding.dto = item
    }

    fun itemClick() {
        fragmentVM.showRoomCheckDialog.shotOne(adapterPosition)
    }
}