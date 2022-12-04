package com.example.aplikasiobengkel.ui.chat

import android.media.MediaExtractor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aplikasiobengkel.R
import com.example.aplikasiobengkel.data.model.Chat
import com.example.aplikasiobengkel.data.model.Promo
import com.example.aplikasiobengkel.databinding.ActivityChatBinding
import com.example.aplikasiobengkel.databinding.ActivityRegisterBinding
import com.example.aplikasiobengkel.ui.adapter.ChatAdapter
import com.example.aplikasiobengkel.ui.adapter.MessageAdapter
import com.example.aplikasiobengkel.ui.auth.register.RegisterViewModel
import com.example.aplikasiobengkel.ui.auth.register.RegisterViewModelFactory

class ChatActivity : AppCompatActivity() {

    private var _binding: ActivityChatBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: ChatViewModel

    private lateinit var adapter: MessageAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = obtainViewModel(this@ChatActivity)

        viewModel.getAllMessage().observe(this) { noteList ->
            if (noteList != null) {
                adapter.setListNotes(noteList)
            }
        }

        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "Pesan"
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        adapter = MessageAdapter()

        binding?.rvMessages?.layoutManager = LinearLayoutManager(this)
        binding?.rvMessages?.setHasFixedSize(true)
        binding?.rvMessages?.adapter = adapter


    }




    private fun obtainViewModel(activity: AppCompatActivity): ChatViewModel {
        val factory = ChatViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory).get(ChatViewModel::class.java)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

//    companion object{
//
//    }
}