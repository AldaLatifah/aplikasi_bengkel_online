package com.example.aplikasiobengkel.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.aplikasiobengkel.data.helper.ChatDiffCallback
import com.example.aplikasiobengkel.data.helper.CraneDiffCallback
import com.example.aplikasiobengkel.data.model.Chat
import com.example.aplikasiobengkel.data.model.Crane
import com.example.aplikasiobengkel.databinding.ItemMyBubbleBinding
import com.example.aplikasiobengkel.databinding.ItemRowHistoryBinding

class ChatAdapter() : RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {

    private val listChat = ArrayList<Chat>()


    fun setListNotes(listNotes: List<Chat>) {
        val diffCallback = ChatDiffCallback(this.listChat, listNotes)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        this.listChat.clear()
        this.listChat.addAll(listNotes)
        diffResult.dispatchUpdatesTo(this)
    }

    inner class ChatViewHolder(private val binding: ItemMyBubbleBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(chat: Chat) {
            with(binding) {
                messageText.text = chat.detail_chat
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val binding = ItemMyBubbleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChatViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        holder.bind(listChat[position])
    }

    override fun getItemCount(): Int {
        return listChat.size
    }

}