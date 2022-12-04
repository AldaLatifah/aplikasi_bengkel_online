package com.example.aplikasiobengkel.ui.auth.forgetpassword

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aplikasiobengkel.data.model.User
import com.example.aplikasiobengkel.data.repository.UserRepository
import kotlinx.coroutines.launch

class ForgetPasswordViewModel (application: Application) : ViewModel() {
    private val repository: UserRepository = UserRepository(application)
    private var _account = MutableLiveData<User?>()
    val account get() = _account


    fun checkEmail(email: String) {
        viewModelScope.launch {
            _account.value = repository.getUsername(email)
        }
    }

    fun updatePassword(email: String, password:String) {
        viewModelScope.launch {
            repository.updatePassword(email, password)
        }
    }
}