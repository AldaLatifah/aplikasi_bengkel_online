package com.example.aplikasiobengkel.ui.chat

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.aplikasiobengkel.ui.history.HistoryViewModel
import com.example.aplikasiobengkel.ui.history.HistoryViewModelFactory
import java.lang.IllegalArgumentException

class ChatViewModelFactory  private constructor(private val mApplication: Application) : ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var INSTANCE: ChatViewModelFactory? = null
        @JvmStatic
        fun getInstance(application: Application): ChatViewModelFactory {
            if (INSTANCE == null) {
                synchronized(ChatViewModelFactory::class.java) {
                    INSTANCE = ChatViewModelFactory(application)
                }
            }
            return INSTANCE as ChatViewModelFactory
        }
    }

    @Suppress("Unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ChatViewModel::class.java)) {
            return ChatViewModel(mApplication) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}