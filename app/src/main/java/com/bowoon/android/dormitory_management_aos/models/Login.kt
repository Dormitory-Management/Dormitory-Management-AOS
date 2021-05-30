package com.bowoon.android.dormitory_management_aos.models

data class LoginData(
    val id: String? = null,
    val password: String? = null
)

data class LoginResponse(
    val state: Int? = null,
    val message: String? = null
)