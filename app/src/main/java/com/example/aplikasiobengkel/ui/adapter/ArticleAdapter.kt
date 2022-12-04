package com.example.aplikasiobengkel.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.aplikasiobengkel.data.model.Article
import com.example.aplikasiobengkel.databinding.ItemRowArticleBinding

class ArticleAdapter(private val listArticle: List<Article>) : RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {
    class ViewHolder(
        var binding: ItemRowArticleBinding
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRowArticleBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = listArticle[position]

        holder.binding.apply {
            Glide.with(holder.itemView.context)
                .load(category.thumbnail)
                .apply(RequestOptions().override(100, 100))
                .into(tvPicRecommendation)
            tvTitleRecommendation.text = category.title
        }
    }

    override fun getItemCount(): Int = listArticle.count()

}