package com.example.aplikasiobengkel.ui.adapter


import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.aplikasiobengkel.data.model.Article
import com.example.aplikasiobengkel.databinding.ItemRowArticleBinding
import com.example.aplikasiobengkel.ui.article.ArticleActivity
import com.example.aplikasiobengkel.ui.chat.DetailChatActivity


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

            val article = Article(
                category.thumbnail,
                category.title,
                category.content
            )
            cardViewArticle.setOnClickListener {
                val intent = Intent(it.context, ArticleActivity::class.java)
                intent.putExtra(ArticleActivity.EXTRA_ARTICLE, article)
                it.context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int = listArticle.count()

}
