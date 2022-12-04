package com.example.aplikasiobengkel.data.helper

import androidx.recyclerview.widget.DiffUtil
import com.example.aplikasiobengkel.data.model.Crane

class CraneDiffCallback(private val mOldCraneList: List<Crane>, private val mNewCraneList: List<Crane>) : DiffUtil.Callback()  {

    override fun getOldListSize(): Int {
        return mOldCraneList.size
    }

    override fun getNewListSize(): Int {
        return mNewCraneList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return mOldCraneList[oldItemPosition].id == mNewCraneList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldEmployee = mOldCraneList[oldItemPosition]
        val newEmployee = mNewCraneList[newItemPosition]
        return oldEmployee.bengkel_name == newEmployee.bengkel_name
                && oldEmployee.merk_mobil == newEmployee.merk_mobil
                && oldEmployee.type_mobil == newEmployee.type_mobil
                && oldEmployee.varian_mobil == newEmployee.varian_mobil
                && oldEmployee.lokasi == newEmployee.lokasi
                && oldEmployee.lokasi_tujuan == newEmployee.lokasi_tujuan
                && oldEmployee.keterangan == newEmployee.keterangan
                && oldEmployee.type == newEmployee.type
    }

}