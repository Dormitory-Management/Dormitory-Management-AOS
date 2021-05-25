package com.bowoon.android.dormitory_management_aos.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bowoon.android.dormitory_management_aos.R
import com.bowoon.android.dormitory_management_aos.base.BaseViewModel
import com.bowoon.android.dormitory_management_aos.fragments.check.viewmodels.CheckFragmentViewModel
import com.bowoon.android.dormitory_management_aos.list.viewholders.CheckViewHolder
import com.bowoon.android.dormitory_management_aos.list.viewholders.NoticeViewHolder
import com.bowoon.android.dormitory_management_aos.list.viewholders.PeopleViewHolder
import com.bowoon.android.dormitory_management_aos.models.Check
import com.bowoon.android.dormitory_management_aos.models.Notice
import com.bowoon.android.dormitory_management_aos.models.People

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
        }
    }

    fun <T> bindViewHolder(holder: RecyclerView.ViewHolder, position: Int, item: T?) {
        item?.let {
            when (holder) {
                is NoticeViewHolder -> { holder.bind(item as Notice) }
                is CheckViewHolder -> { holder.bind(item as Check) }
                is PeopleViewHolder -> { holder.bind(item as People, position) }
            }
        }
    }
}