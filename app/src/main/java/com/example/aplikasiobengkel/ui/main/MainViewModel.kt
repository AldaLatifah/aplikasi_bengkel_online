package com.example.aplikasiobengkel.ui.main

import androidx.lifecycle.ViewModel
import com.example.aplikasiobengkel.data.repository.DataRepository

class MainViewModel : ViewModel() {
    private val repository = DataRepository()
    fun getMenuCategory() = repository.getMenuCategory()
    fun getDataArticle() = repository.getDataArticle()
}