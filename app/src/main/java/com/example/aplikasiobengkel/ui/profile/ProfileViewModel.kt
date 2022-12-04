package com.example.aplikasiobengkel.ui.profile

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aplikasiobengkel.data.model.User
import com.example.aplikasiobengkel.data.repository.DataRepository
import com.example.aplikasiobengkel.data.repository.UserRepository
import kotlinx.coroutines.launch

class ProfileViewModel(application: Application) : ViewModel(){
    private val repository = DataRepository()
    private val userrepository: UserRepository = UserRepository(application)
    fun getProfileCategory() = repository.getProfileCategory()

    private var _account = MutableLiveData<User?>()
    val account get() = _account

    fun checkEmail(email:String) {
        viewModelScope.launch {
            _account.value = userrepository.getUsername(email)
        }
    }
}