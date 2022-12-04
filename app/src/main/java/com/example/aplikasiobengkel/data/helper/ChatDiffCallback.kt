package com.example.aplikasiobengkel.data.helper

import androidx.recyclerview.widget.DiffUtil
import com.example.aplikasiobengkel.data.model.Chat
import com.example.aplikasiobengkel.data.model.Crane

class ChatDiffCallback (private val mOldCraneList: List<Chat>, private val mNewCraneList: List<Chat>) : DiffUtil.Callback()  {

    override fun getOldListSize(): Int {
        return mOldCraneList.size
    }

    override fun getNewListSize(): Int {
        return mNewCraneList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return mOldCraneList[oldItemPosition].id == mNewCraneList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldEmployee = mOldCraneList[oldItemPosition]
        val newEmployee = mNewCraneList[newItemPosition]
        return oldEmployee.detail_chat == newEmployee.detail_chat
    }
}