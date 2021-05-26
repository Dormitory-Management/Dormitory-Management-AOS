package com.bowoon.android.dormitory_management_aos.models

data class CheckData(
    var data: MutableList<Check>? = null
)

data class Check(
    var id: Int? = null,
    var roomNumber: Int? = null,
    var people: MutableList<People>? = null
)

data class People(
    val name: String? = null,
    val profileImage: String? = null,
    val type: String? = null,
    var check: Boolean = false
)