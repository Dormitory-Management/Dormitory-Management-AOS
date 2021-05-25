package com.bowoon.android.dormitory_management_aos.list.viewholders

import com.bowoon.android.dormitory_management_aos.base.BaseViewHolder
import com.bowoon.android.dormitory_management_aos.databinding.ViewholderRoomCheckBinding
import com.bowoon.android.dormitory_management_aos.fragments.check.viewmodels.CheckFragmentViewModel
import com.bowoon.android.dormitory_management_aos.models.People

class PeopleViewHolder(
    private val binding: ViewholderRoomCheckBinding,
    private val fragmentVM: CheckFragmentViewModel
) : BaseViewHolder(binding.root) {
    fun bind(item: People, position: Int) {
        binding.dto = item

        fragmentVM.checkList.value?.data?.get(position)?.people?.get(adapterPosition)?.check = binding.cbPeopleCheck.isChecked
    }
}