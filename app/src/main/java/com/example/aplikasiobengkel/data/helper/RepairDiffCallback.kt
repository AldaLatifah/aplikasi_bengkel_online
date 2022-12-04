package com.example.aplikasiobengkel.data.helper

import androidx.recyclerview.widget.DiffUtil
import com.example.aplikasiobengkel.data.model.Crane
import com.example.aplikasiobengkel.data.model.Repair

class RepairDiffCallback (private val mOldRepairList: List<Repair>, private val mNewRepairList: List<Repair>) : DiffUtil.Callback()  {

    override fun getOldListSize(): Int {
        return mOldRepairList.size
    }

    override fun getNewListSize(): Int {
        return mNewRepairList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return mOldRepairList[oldItemPosition].id == mNewRepairList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldEmployee = mOldRepairList[oldItemPosition]
        val newEmployee = mNewRepairList[newItemPosition]
        return oldEmployee.montir_name == newEmployee.montir_name
                && oldEmployee.merk_mobil == newEmployee.merk_mobil
                && oldEmployee.type_mobil == newEmployee.type_mobil
                && oldEmployee.varian_mobil == newEmployee.varian_mobil
                && oldEmployee.keluhan == newEmployee.keluhan
                && oldEmployee.date == newEmployee.date
                && oldEmployee.time == newEmployee.time
                && oldEmployee.type == newEmployee.type
    }

}