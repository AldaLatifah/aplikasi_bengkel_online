package com.example.aplikasiobengkel.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aplikasiobengkel.data.model.Mechanic
import com.example.aplikasiobengkel.databinding.ItemRowMechanicBinding

class MechanicAdapter(private val listMontir: List<Mechanic>) : RecyclerView.Adapter<MechanicAdapter.ViewHolder>() {

    class ViewHolder(
        var binding: ItemRowMechanicBinding
    ) : RecyclerView.ViewHolder(binding.root)

    private lateinit var onItemClickCallback: MechanicAdapter.OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(moduleCategory: Mechanic)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding = ItemRowMechanicBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = listMontir[position]

        holder.binding.apply {
            tvNameMontir.text = category.name
            tvAgeMontir.text = category.age
            tvLocationMontir.text = category.location
            tvRate.text = category.rate
        }

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(category)
        }
    }

    override fun getItemCount(): Int = listMontir.count()
}