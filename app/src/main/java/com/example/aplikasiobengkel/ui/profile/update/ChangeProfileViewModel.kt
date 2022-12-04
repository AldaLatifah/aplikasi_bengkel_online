package com.example.aplikasiobengkel.ui.profile.update

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aplikasiobengkel.data.model.User
import com.example.aplikasiobengkel.data.repository.UserRepository
import kotlinx.coroutines.launch

class ChangeProfileViewModel(application: Application) : ViewModel() {
    private val repository: UserRepository = UserRepository(application)
    fun update(accounts: User) {
        viewModelScope.launch {
            repository.update(accounts)
        }
    }
}