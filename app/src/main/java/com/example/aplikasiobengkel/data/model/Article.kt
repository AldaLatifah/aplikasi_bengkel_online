package com.example.aplikasiobengkel.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Article(
    val thumbnail: Int,
    val title: String,
    val content : String
): Parcelable
