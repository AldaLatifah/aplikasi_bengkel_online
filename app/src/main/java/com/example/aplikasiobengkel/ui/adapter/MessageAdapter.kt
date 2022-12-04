package com.example.aplikasiobengkel.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.aplikasiobengkel.data.helper.ChatDiffCallback
import com.example.aplikasiobengkel.data.helper.CraneDiffCallback
import com.example.aplikasiobengkel.data.model.Chat
import com.example.aplikasiobengkel.data.model.Crane
import com.example.aplikasiobengkel.databinding.ItemRowHistoryBinding
import com.example.aplikasiobengkel.databinding.ItemRowMessageBinding
import com.example.aplikasiobengkel.ui.chat.DetailChatActivity
import com.example.aplikasiobengkel.ui.history.DetailCraneHistoryActivity

class MessageAdapter: RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {

    private val listMessage = ArrayList<Chat>()
    fun setListNotes(listNotes: List<Chat>) {
        val diffCallback = ChatDiffCallback(this.listMessage, listNotes)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        this.listMessage.clear()
        this.listMessage.addAll(listNotes)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val binding = ItemRowMessageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MessageViewHolder(binding)
    }
    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        holder.bind(listMessage[position])
    }
    override fun getItemCount(): Int {
        return listMessage.size
    }
    inner class MessageViewHolder(private val binding: ItemRowMessageBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(chat: Chat) {
            with(binding) {
               tvNameMontir.text = chat.to_name
                cardViewMessage.setOnClickListener {
                    val intent = Intent(it.context, DetailChatActivity::class.java)
                    intent.putExtra(DetailChatActivity.EXTRA_CHAT, chat)
                    it.context.startActivity(intent)
                }
            }
        }
    }
}