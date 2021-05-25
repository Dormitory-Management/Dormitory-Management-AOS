package com.bowoon.android.dormitory_management_aos.adapter

import com.bowoon.android.dormitory_management_aos.base.BaseRecyclerViewAdapter
import com.bowoon.android.dormitory_management_aos.list.ListType
import com.bowoon.android.dormitory_management_aos.models.Check

class CheckAdapter : BaseRecyclerViewAdapter<Check>() {
    override fun getItemViewType(position: Int) = ListType.CHECK.ordinal
}