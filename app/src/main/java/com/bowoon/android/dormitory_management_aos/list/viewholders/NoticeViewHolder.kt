package com.bowoon.android.dormitory_management_aos.list.viewholders

import com.bowoon.android.dormitory_management_aos.R
import com.bowoon.android.dormitory_management_aos.base.BaseViewHolder
import com.bowoon.android.dormitory_management_aos.databinding.ViewholderNoticeBinding
import com.bowoon.android.dormitory_management_aos.models.Notice
import com.google.android.material.snackbar.Snackbar
import java.text.SimpleDateFormat
import java.util.*

class NoticeViewHolder(private val binding: ViewholderNoticeBinding) : BaseViewHolder(binding.root) {
    fun bind(item: Notice) {
        binding.vh = this
        binding.dto = item
    }

    fun itemClick() {
        Snackbar.make(binding.root, "itemClick $adapterPosition", Snackbar.LENGTH_SHORT).apply {
            anchorView = binding.root.rootView.findViewById(R.id.bnv_bottom_footer)
        }.show()
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