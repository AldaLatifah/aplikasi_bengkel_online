package com.example.aplikasiobengkel.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.aplikasiobengkel.data.helper.CraneDiffCallback
import com.example.aplikasiobengkel.data.helper.RepairDiffCallback
import com.example.aplikasiobengkel.data.model.Crane
import com.example.aplikasiobengkel.data.model.Repair
import com.example.aplikasiobengkel.databinding.ItemRowHistoryBinding
import com.example.aplikasiobengkel.ui.history.DetailCraneHistoryActivity
import com.example.aplikasiobengkel.ui.history.DetailRepairHistoryActivity

class RepairAdapter : RecyclerView.Adapter<RepairAdapter.CraneViewHolder>() {

    private val listRepair = ArrayList<Repair>()

    fun setListNotes(listNotes: List<Repair>) {
        val diffCallback = RepairDiffCallback(this.listRepair, listNotes)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        this.listRepair.clear()
        this.listRepair.addAll(listNotes)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CraneViewHolder {
        val binding = ItemRowHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CraneViewHolder(binding)
    }
    override fun onBindViewHolder(holder: CraneViewHolder, position: Int) {
        holder.bind(listRepair[position])
    }
    override fun getItemCount(): Int {
        return listRepair.size
    }
    inner class CraneViewHolder(private val binding: ItemRowHistoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(repair: Repair) {
            with(binding) {
                tvCodeTransaction.text = repair.montir_name
                tvStatusTransaction.text = repair.type
                tvTotalPrice.text = repair.date
                tvTypeService.text = repair.keluhan
                cardViewHistory.setOnClickListener {
                    val intent = Intent(it.context, DetailRepairHistoryActivity::class.java)
                    intent.putExtra(DetailRepairHistoryActivity.EXTRA_REPAIR, repair)
                    it.context.startActivity(intent)
                }
            }
        }
    }
}