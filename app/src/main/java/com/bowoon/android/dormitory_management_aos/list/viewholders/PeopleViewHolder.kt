package com.bowoon.android.dormitory_management_aos.list.viewholders

import com.bowoon.android.dormitory_management_aos.base.BaseViewHolder
import com.bowoon.android.dormitory_management_aos.databinding.ViewholderRoomCheckBinding
import com.bowoon.android.dormitory_management_aos.models.People

class PeopleViewHolder(
    private val binding: ViewholderRoomCheckBinding
) : BaseViewHolder<People>(binding.root) {
    override fun bind(item: People) {
        binding.dto = item
    }
}