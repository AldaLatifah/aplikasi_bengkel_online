package com.example.aplikasiobengkel.ui.article

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.aplikasiobengkel.data.model.Article
import com.example.aplikasiobengkel.data.model.Crane
import com.example.aplikasiobengkel.databinding.ActivityArticleBinding
import com.example.aplikasiobengkel.databinding.ActivityLoginBinding
import com.example.aplikasiobengkel.ui.history.DetailCraneHistoryActivity

class ArticleActivity : AppCompatActivity() {
    private var _binding: ActivityArticleBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "Artikel O Bengkel"
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        val article = intent.getParcelableExtra<Article>(EXTRA_ARTICLE) as Article

        Glide.with(this)
            .load(article.thumbnail)
            .apply(RequestOptions().override(100, 100))
            .into(binding.tvPicArticle)
        binding.tvTitleArticle.text = article.title
        binding.tvContent.text = article.content
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object{
        const val EXTRA_ARTICLE ="extra_article"
    }
}