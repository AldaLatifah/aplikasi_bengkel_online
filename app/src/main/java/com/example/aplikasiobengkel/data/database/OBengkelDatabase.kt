package com.example.aplikasiobengkel.data.database

import android.content.Context
import androidx.room.*
import com.example.aplikasiobengkel.data.database.dao.ChatDao
import com.example.aplikasiobengkel.data.database.dao.CraneDao
import com.example.aplikasiobengkel.data.database.dao.RepairDao
import com.example.aplikasiobengkel.data.database.dao.UserDao
import com.example.aplikasiobengkel.data.model.Chat
import com.example.aplikasiobengkel.data.model.Crane
import com.example.aplikasiobengkel.data.model.Repair
import com.example.aplikasiobengkel.data.model.User

@Database(entities = [User::class, Repair::class, Crane::class, Chat::class], version = 1, exportSchema = false)
abstract class OBengkelDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun repairDao() : RepairDao
    abstract fun craneDao() : CraneDao
    abstract fun chatDao() : ChatDao

    companion object {
        @Volatile
        private var INSTANCE: OBengkelDatabase? = null
        @JvmStatic
        fun getDatabase(context: Context): OBengkelDatabase {
            if (INSTANCE == null) {
                synchronized(OBengkelDatabase::class.java) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        OBengkelDatabase::class.java, "db_workshop")
                        .build()
                }
            }
            return INSTANCE as OBengkelDatabase
        }
    }
}