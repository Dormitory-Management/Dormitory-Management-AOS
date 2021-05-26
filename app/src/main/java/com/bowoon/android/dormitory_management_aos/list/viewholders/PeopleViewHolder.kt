package com.bowoon.android.dormitory_management_aos.list.viewholders

import com.bowoon.android.dormitory_management_aos.R
import com.bowoon.android.dormitory_management_aos.base.BaseViewHolder
import com.bowoon.android.dormitory_management_aos.databinding.ViewholderRoomCheckBinding
import com.bowoon.android.dormitory_management_aos.fragments.check.viewmodels.CheckFragmentViewModel
import com.bowoon.android.dormitory_management_aos.models.People
import com.bumptech.glide.Glide

class PeopleViewHolder(
    private val binding: ViewholderRoomCheckBinding,
    private val fragmentVM: CheckFragmentViewModel
) : BaseViewHolder(binding.root) {
    fun bind(item: People) {
        binding.dto = item

        if (item.profileImage != null) {
            Glide.with(binding.root.context)
                .load(item.profileImage)
                .into(binding.ivProfileImage)
        } else {
            binding.ivProfileImage.setImageResource(R.mipmap.ic_launcher)
        }

        binding.cbPeopleCheck.isChecked = item.check

        binding.cbPeopleCheck.setOnClickListener {
            fragmentVM.checkList.value?.data?.get(fragmentVM.roomIndex)?.people?.get(adapterPosition)?.check = binding.cbPeopleCheck.isChecked
        }
    }
}