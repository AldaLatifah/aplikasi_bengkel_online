package com.example.aplikasiobengkel.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.aplikasiobengkel.data.model.Promo
import com.example.aplikasiobengkel.databinding.ItemRowPromoBinding

class PromoAdapter(private val listPromo: List<Promo>) : RecyclerView.Adapter<PromoAdapter.ViewHolder>()  {
    class ViewHolder (var binding: ItemRowPromoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRowPromoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = listPromo[position]

        holder.binding.apply {
            Glide.with(holder.itemView.context)
                .load(category.thumbnail)
                .apply(RequestOptions().override(100, 100))
                .into(tvPicRecommendation)
            tvTitleRecommendation.text = category.title
        }
    }

    override fun getItemCount(): Int = listPromo.count()
}