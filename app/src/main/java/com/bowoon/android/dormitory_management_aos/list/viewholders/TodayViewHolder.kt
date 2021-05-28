package com.bowoon.android.dormitory_management_aos.list.viewholders

import com.bowoon.android.dormitory_management_aos.base.BaseViewHolder
import com.bowoon.android.dormitory_management_aos.databinding.ViewholderTodayBinding
import com.bowoon.android.dormitory_management_aos.models.TodayList

class TodayViewHolder(
    private val binding: ViewholderTodayBinding
) : BaseViewHolder(binding.root) {
    fun bind(item: TodayList) {
        binding.dto = item
    }
}