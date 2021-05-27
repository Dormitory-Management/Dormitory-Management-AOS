package com.bowoon.android.dormitory_management_aos.models

data class CheckData(
    val data: MutableList<Check>? = null
)

data class Check(
    val id: Int? = null,
    val roomNumber: Int? = null,
    val people: MutableList<People>? = null
)

data class People(
    val name: String? = null,
    val profileImage: String? = null,
    val type: String? = null,
    var check: Boolean = false
)