package com.example.aplikasiobengkel.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.aplikasiobengkel.data.model.Crane
import com.example.aplikasiobengkel.data.model.User

@Dao
interface CraneDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(crane: Crane)

    @Query("SELECT * from crane ORDER BY id ASC")
    fun getAllCranes(): LiveData<List<Crane>>

    @Query("SELECT * FROM crane WHERE bengkel_name LIKE :bengkel_name")
    fun getBengkelName(bengkel_name: String): Crane
}