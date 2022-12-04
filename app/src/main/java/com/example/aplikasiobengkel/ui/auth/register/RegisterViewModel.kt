package com.example.aplikasiobengkel.ui.auth.register

import android.app.Application
import androidx.lifecycle.*
import com.example.aplikasiobengkel.data.repository.UserRepository
import com.example.aplikasiobengkel.data.model.User
import kotlinx.coroutines.launch

class RegisterViewModel(application: Application) : ViewModel() {

    private val repository: UserRepository = UserRepository(application)
    private var _account = MutableLiveData<User?>()
    val account get() = _account

    fun register(accounts: User) {
        viewModelScope.launch {
            repository.insert(accounts)
        }
    }

    fun checkEmail(email:String) {
        viewModelScope.launch {
            _account.value = repository.getUsername(email)
        }
    }

}