package com.example.aplikasiobengkel.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aplikasiobengkel.data.model.ServiceStation
import com.example.aplikasiobengkel.databinding.ItemRowServiceStationBinding

class ServiceStationAdapter(private val listMontir: List<ServiceStation>) : RecyclerView.Adapter<ServiceStationAdapter.ViewHolder>()  {

    class ViewHolder(
        var binding: ItemRowServiceStationBinding
    ) : RecyclerView.ViewHolder(binding.root)

    private lateinit var onItemClickCallback: ServiceStationAdapter.OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(moduleCategory: ServiceStation)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding = ItemRowServiceStationBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = listMontir[position]

        holder.binding.apply {
            tvNameDerek.text = category.name
            tvLocation.text = category.location
            tvPrice.text = category.price
        }

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(category)
        }
    }

    override fun getItemCount(): Int = listMontir.count()
}