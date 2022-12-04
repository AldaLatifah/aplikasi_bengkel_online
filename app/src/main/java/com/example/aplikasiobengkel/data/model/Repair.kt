package com.example.aplikasiobengkel.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "repair")
@Parcelize
data class Repair(
    var montir_name : String?,
    var merk_mobil : String?,
    var type_mobil : String?,
    var varian_mobil : String?,
    var keluhan : String?,
    var date : String?,
    var time : String?,
    var alamat : String?,
    var type : String?,
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
): Parcelable
