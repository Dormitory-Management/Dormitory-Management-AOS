package com.bowoon.android.dormitory_management_aos.models

data class CheckData(
    val isActive: Boolean? = null,
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

data class SendCheckData(
    val data: MutableList<Check>? = null
)

data class RoomCheckResponse(
    val state: Int? = null,
    val message: String? = null
)