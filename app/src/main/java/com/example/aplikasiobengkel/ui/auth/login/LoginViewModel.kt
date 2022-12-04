package com.example.aplikasiobengkel.ui.auth.login

import android.app.Application
import androidx.lifecycle.*
import com.example.aplikasiobengkel.data.repository.UserRepository
import com.example.aplikasiobengkel.data.model.User
import kotlinx.coroutines.launch


class LoginViewModel(application: Application) : ViewModel(){
    private val repository: UserRepository = UserRepository(application)
    private var _account = MutableLiveData<User?>()
    val account get() = _account


    fun login(email:String) {
       viewModelScope.launch {
           _account.value = repository.getUsername(email)
       }
    }

    fun update(accounts: User) {
        viewModelScope.launch {
            repository.update(accounts)
        }
    }

}