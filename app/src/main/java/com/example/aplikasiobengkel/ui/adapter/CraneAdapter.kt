package com.example.aplikasiobengkel.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.aplikasiobengkel.data.helper.CraneDiffCallback
import com.example.aplikasiobengkel.data.model.Crane
import com.example.aplikasiobengkel.databinding.ItemRowHistoryBinding
import com.example.aplikasiobengkel.databinding.ItemRowServiceStationBinding
import com.example.aplikasiobengkel.ui.history.DetailCraneHistoryActivity

class CraneAdapter: RecyclerView.Adapter<CraneAdapter.CraneViewHolder>() {

    private val listCrane = ArrayList<Crane>()

    fun setListNotes(listNotes: List<Crane>) {
        val diffCallback = CraneDiffCallback(this.listCrane, listNotes)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        this.listCrane.clear()
        this.listCrane.addAll(listNotes)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CraneViewHolder {
        val binding = ItemRowHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CraneViewHolder(binding)
    }
    override fun onBindViewHolder(holder: CraneViewHolder, position: Int) {
        holder.bind(listCrane[position])
    }
    override fun getItemCount(): Int {
        return listCrane.size
    }
    inner class CraneViewHolder(private val binding: ItemRowHistoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(crane: Crane) {
            with(binding) {
                tvCodeTransaction.text = crane.bengkel_name
                tvStatusTransaction.text = crane.type
                tvTotalPrice.text = "123000"
                tvTypeService.text = "DEREK"
                cardViewHistory.setOnClickListener {
                    val intent = Intent(it.context, DetailCraneHistoryActivity::class.java)
                    intent.putExtra(DetailCraneHistoryActivity.EXTRA_CRANE, crane)
                    it.context.startActivity(intent)
                }
            }
        }
    }
}