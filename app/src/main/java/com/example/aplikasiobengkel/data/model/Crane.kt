package com.example.aplikasiobengkel.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "crane")
@Parcelize
data class Crane(
    var bengkel_name : String?,
    var merk_mobil : String?,
    var type_mobil : String?,
    var varian_mobil : String?,
    var lokasi : String?,
    var lokasi_tujuan : String?,
    var keterangan : String?,
    var type : String?,
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
): Parcelable
