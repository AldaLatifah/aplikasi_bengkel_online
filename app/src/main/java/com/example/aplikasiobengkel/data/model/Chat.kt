package com.example.aplikasiobengkel.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "chat")
@Parcelize
data class Chat(
    val to_name : String?,
    val detail_chat : String?,
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
): Parcelable
