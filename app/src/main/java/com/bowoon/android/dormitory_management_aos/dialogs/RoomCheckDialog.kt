package com.bowoon.android.dormitory_management_aos.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.bowoon.android.dormitory_management_aos.R
import com.bowoon.android.dormitory_management_aos.adapter.PeopleAdapter
import com.bowoon.android.dormitory_management_aos.databinding.DialogRoomCheckBinding
import com.bowoon.android.dormitory_management_aos.fragments.check.viewmodels.CheckFragmentViewModel
import com.bowoon.android.dormitory_management_aos.models.People
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class RoomCheckDialog(
    private val items: MutableList<People>? = null,
    private val fragmentVM: CheckFragmentViewModel? = null
) : BottomSheetDialogFragment() {
    private lateinit var binding: DialogRoomCheckBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NORMAL, R.style.RoomCheckPopup)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.dialog_room_check, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        items?.let { peopleList ->
            binding.rvPeople.adapter = PeopleAdapter().also {
                it.items = peopleList
            }
        }

        binding.tvBottomSheetDialogClose.setOnClickListener {
            dismissAllowingStateLoss()
        }
    }

    companion object {
        const val TAG = "RoomCheckDialog"
    }
}