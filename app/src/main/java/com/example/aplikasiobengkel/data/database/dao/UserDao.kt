package com.example.aplikasiobengkel.data.database.dao

import androidx.room.*
import com.example.aplikasiobengkel.data.model.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User)

    @Query("SELECT * FROM user WHERE email LIKE :email")
    fun getUsername(email: String):User

    @Update
    fun update(user: User)

    @Query("UPDATE user SET password =:password  WHERE email =:email")
    fun updatePassword(email: String, password:String)
}