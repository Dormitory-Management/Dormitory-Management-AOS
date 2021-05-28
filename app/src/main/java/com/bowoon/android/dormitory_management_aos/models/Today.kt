package com.bowoon.android.dormitory_management_aos.models

data class TodayData(
    val data: Today? = null
)

data class Today(
    val title: String? = null,
    val time: String? = null,
    val todayList: MutableList<TodayList>? = null
)

data class TodayList(
    val title: String? = null,
    val content: String? = null
)