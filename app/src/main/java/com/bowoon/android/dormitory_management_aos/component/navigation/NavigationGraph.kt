package com.bowoon.android.dormitory_management_aos.component.navigation

import com.bowoon.android.dormitory_management_aos.R

interface NavigationGraph {
    fun getGraphList(): MutableList<Int>
    fun getGraphIdList(): MutableList<Int>
}

class NavigationGraphImpl() : NavigationGraph {
    override fun getGraphList(): MutableList<Int> {
        return mutableListOf(R.navigation.fragment_home, R.navigation.fragment_check, R.navigation.fragment_notice)
    }

    override fun getGraphIdList(): MutableList<Int> {
        return mutableListOf(R.id.fragment_home, R.id.fragment_check, R.id.fragment_notice)
    }
}