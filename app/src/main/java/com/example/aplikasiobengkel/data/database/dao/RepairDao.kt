package com.example.aplikasiobengkel.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.aplikasiobengkel.data.model.Repair
import com.example.aplikasiobengkel.data.model.User

@Dao
interface RepairDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(repair: Repair)

    @Query("SELECT * from repair ORDER BY id ASC")
    fun getAllRepairs(): LiveData<List<Repair>>

    @Query("SELECT * FROM repair WHERE montir_name LIKE :montir_name")
    fun getMontirName(montir_name: String): Repair
}
