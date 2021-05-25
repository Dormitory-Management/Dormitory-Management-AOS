package com.bowoon.android.dormitory_management_aos.adapter

import com.bowoon.android.dormitory_management_aos.base.BaseRecyclerViewAdapter
import com.bowoon.android.dormitory_management_aos.list.ListType
import com.bowoon.android.dormitory_management_aos.models.Check
import com.bowoon.android.dormitory_management_aos.models.Notice
import com.bowoon.android.dormitory_management_aos.models.People

class CheckAdapter : BaseRecyclerViewAdapter<Check>() {
    override fun getItemViewType(position: Int) = ListType.CHECK.ordinal
}

class NoticeAdapter : BaseRecyclerViewAdapter<Notice>() {
    override fun getItemViewType(position: Int) = ListType.NOTICE.ordinal
}

class PeopleAdapter : BaseRecyclerViewAdapter<People>() {
    override fun getItemViewType(position: Int) = ListType.PEOPLE.ordinal
}