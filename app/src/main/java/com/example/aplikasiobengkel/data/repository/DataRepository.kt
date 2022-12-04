package com.example.aplikasiobengkel.data.repository

import com.example.aplikasiobengkel.data.local.Data

class DataRepository {
    fun getMenuCategory() = Data.getMenuCategory()
    fun getProfileCategory() = Data.getProfileCategory()
    fun getDataMechanic() = Data.getDataMechanic()
    fun getDataServiceStation() = Data.getDataServiceStation()
    fun getDataArticle() = Data.getDataArticle()
    fun getDataPromo() = Data.getDataPromo()
}