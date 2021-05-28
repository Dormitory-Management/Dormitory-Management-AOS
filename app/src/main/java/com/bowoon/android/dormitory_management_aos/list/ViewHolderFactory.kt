package com.bowoon.android.dormitory_management_aos.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bowoon.android.dormitory_management_aos.R
import com.bowoon.android.dormitory_management_aos.base.BaseViewModel
import com.bowoon.android.dormitory_management_aos.fragments.check.viewmodels.CheckFragmentViewModel
import com.bowoon.android.dormitory_management_aos.list.viewholders.*
import com.bowoon.android.dormitory_management_aos.models.*

object ViewHolderFactory {
    fun createViewHolder(type: ListType, parent: ViewGroup, activityVM: BaseViewModel? = null, fragmentVM: BaseViewModel? = null): RecyclerView.ViewHolder {
        return when (type) {
            ListType.NOTICE -> {
                NoticeViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.viewholder_notice, parent, false))
            }
            ListType.CHECK -> {
                CheckViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.viewholder_check, parent, false), fragmentVM as CheckFragmentViewModel)
            }
            ListType.PEOPLE -> {
                PeopleViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.viewholder_room_check, parent, false), fragmentVM as CheckFragmentViewModel)
            }
            ListType.TODAY -> {
                TodayViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.viewholder_today, parent, false))
            }
        }
    }

    fun <T> bindViewHolder(holder: RecyclerView.ViewHolder, position: Int, item: T?) {
        item?.let {
            when (holder) {
                is NoticeViewHolder -> { holder.bind(item as Notice) }
                is CheckViewHolder -> { holder.bind(item as Check) }
                is PeopleViewHolder -> { holder.bind(item as People) }
                is TodayViewHolder -> { holder.bind(item as TodayList) }
            }
        }
    }
}