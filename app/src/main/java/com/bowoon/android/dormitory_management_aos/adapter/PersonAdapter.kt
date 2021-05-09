package com.bowoon.android.dormitory_management_aos.adapter

import com.bowoon.android.dormitory_management_aos.base.BaseRecyclerViewAdapter
import com.bowoon.android.dormitory_management_aos.list.ListType
import com.bowoon.android.dormitory_management_aos.models.Person

class PersonAdapter : BaseRecyclerViewAdapter<Person>() {
    override fun getItemViewType(position: Int) = ListType.PERSON.ordinal
}