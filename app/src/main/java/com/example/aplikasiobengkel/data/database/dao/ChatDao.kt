package com.example.aplikasiobengkel.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.aplikasiobengkel.data.model.Chat

@Dao
interface ChatDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(chat: Chat)

    @Query("SELECT * from chat WHERE to_name =:name ORDER BY id ASC")
    fun getAllChat(name:String): LiveData<List<Chat>>

    @Query("SELECT * from chat GROUP BY to_name ORDER BY id DESC")
    fun getAllMessage(): LiveData<List<Chat>>

    @Query("SELECT * FROM chat WHERE to_name LIKE :name")
    fun getIntentionChat(name: String): Chat

    @Query("DELETE FROM chat WHERE to_name = :name")
    fun deleteByName(name: String)
}