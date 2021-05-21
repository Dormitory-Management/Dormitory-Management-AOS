package com.bowoon.android.dormitory_management_aos.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bowoon.android.dormitory_management_aos.R
import com.bowoon.android.dormitory_management_aos.base.BaseViewModel
import com.bowoon.android.dormitory_management_aos.list.viewholders.NoticeViewHolder
import com.bowoon.android.dormitory_management_aos.list.viewholders.PersonViewHolder
import com.bowoon.android.dormitory_management_aos.models.Notice
import com.bowoon.android.dormitory_management_aos.models.Person

object ViewHolderFactory {
    fun createViewHolder(type: ListType, parent: ViewGroup, activityVM: BaseViewModel? = null, fragmentVM: BaseViewModel? = null): RecyclerView.ViewHolder {
        return when (type) {
            ListType.PERSON -> {
                PersonViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.viewholder_person, parent, false))
            }
            ListType.NOTICE -> {
                NoticeViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.viewholder_notice, parent, false))
            }
        }
    }

    fun <T> bindViewHolder(holder: RecyclerView.ViewHolder, position: Int, item: T?) {
        item?.let {
            when (holder) {
                is PersonViewHolder -> { holder.bind(item as Person) }
                is NoticeViewHolder -> { holder.bind(item as Notice) }
            }
        }
    }
}