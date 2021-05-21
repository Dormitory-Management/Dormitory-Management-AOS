package com.bowoon.android.dormitory_management_aos.models

data class Notice(
    val id: Int? = 0,
    val title: String? = null,
    val content: String? = null,
    val date: Long? = 0L,
    val writer: String? = null
)