package com.example.aplikasiobengkel.ui.chat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aplikasiobengkel.R
import com.example.aplikasiobengkel.data.model.Chat
import com.example.aplikasiobengkel.databinding.ActivityChatBinding
import com.example.aplikasiobengkel.databinding.ActivityDetailChatBinding
import com.example.aplikasiobengkel.ui.adapter.ChatAdapter
import com.example.aplikasiobengkel.ui.adapter.MessageAdapter

class DetailChatActivity : AppCompatActivity() {

    private var _binding: ActivityDetailChatBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: ChatViewModel

    private lateinit var adapter: ChatAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailChatBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val chat = intent.getParcelableExtra<Chat>(EXTRA_CHAT)
        viewModel = obtainViewModel(this@DetailChatActivity)

        chat?.to_name?.let {
            viewModel.getAllChat(it).observe(this) { noteList ->
                if (noteList != null) {
                    adapter.setListNotes(noteList)
                }
            }
        }

        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = chat?.to_name
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)


        adapter = ChatAdapter()

        val manager = LinearLayoutManager(this)
        manager.stackFromEnd = true
        binding.rvMessages.layoutManager = manager
        binding.rvMessages.setHasFixedSize(true)
        binding.rvMessages.adapter = adapter

        binding.sendMessage.setOnClickListener{
            val pesan = binding.enterMessage.text.toString().trim()
            viewModel.insert(
                Chat(
                    chat?.to_name,
                    pesan
                )
            )
        }

    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        menuInflater.inflate(R.menu.menu_chat, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_delete -> showAlertDialog(ALERT_DIALOG_DELETE)
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showAlertDialog(type: Int) {
        val dialogMessage = getString(R.string.message_delete)
        val dialogTitle = getString(R.string.delete)

        val chat = intent.getParcelableExtra<Chat>(EXTRA_CHAT)

        val alertDialogBuilder = AlertDialog.Builder(this)
        with(alertDialogBuilder) {
            setTitle(dialogTitle)
            setMessage(dialogMessage)
            setCancelable(false)
            setPositiveButton(getString(R.string.yes)) { _, _ ->
                chat?.to_name?.let { viewModel.delete(it) }

                finish()
            }
            setNegativeButton(getString(R.string.no)) { dialog, _ -> dialog.cancel() }
        }
        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
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

    companion object{
        const val EXTRA_CHAT = "extra_chat"
        const val ALERT_DIALOG_DELETE = 20
    }
}