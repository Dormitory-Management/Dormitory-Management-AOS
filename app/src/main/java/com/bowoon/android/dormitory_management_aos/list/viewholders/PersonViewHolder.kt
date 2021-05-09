package com.bowoon.android.dormitory_management_aos.list.viewholders

import com.bowoon.android.android_template.databinding.ViewholderPersonBinding
import com.bowoon.android.dormitory_management_aos.base.BaseViewHolder
import com.bowoon.android.dormitory_management_aos.models.Person

class PersonViewHolder(
    private val binding: ViewholderPersonBinding
) : BaseViewHolder<Person>(binding.root) {
    override fun bind(item: Person) {
        binding.dto = item
    }
}