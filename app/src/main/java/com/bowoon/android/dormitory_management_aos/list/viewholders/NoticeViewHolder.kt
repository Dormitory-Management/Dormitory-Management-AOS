package com.bowoon.android.dormitory_management_aos.list.viewholders

import com.bowoon.android.common.utils.showShortSnackbar
import com.bowoon.android.dormitory_management_aos.base.BaseViewHolder
import com.bowoon.android.dormitory_management_aos.databinding.ViewholderNoticeBinding
import com.bowoon.android.dormitory_management_aos.models.Notice
import java.text.SimpleDateFormat
import java.util.*

class NoticeViewHolder(private val binding: ViewholderNoticeBinding) : BaseViewHolder<Notice>(binding.root) {
    override fun bind(item: Notice) {
        binding.vh = this
        binding.dto = item
    }

    fun itemClick() {
        binding.root.context.showShortSnackbar(binding.root, "itemClick $adapterPosition")
    }

    fun convertTime(time: Long?, isTime: Boolean = false): String? {
        return time?.let {
            SimpleDateFormat(
                if (isTime) {
                    "yyyy.MM.dd HH:mm"
                } else {
                    "yyyy.MM.dd"
                }, Locale.getDefault()
            ).format(it)
        }
    }
}