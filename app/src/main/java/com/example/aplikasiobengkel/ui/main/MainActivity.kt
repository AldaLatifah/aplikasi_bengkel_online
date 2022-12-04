package com.example.aplikasiobengkel.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.aplikasiobengkel.R
import com.example.aplikasiobengkel.data.local.Data
import com.example.aplikasiobengkel.data.model.Article
import com.example.aplikasiobengkel.data.model.Menu
import com.example.aplikasiobengkel.data.repository.DataRepository
import com.example.aplikasiobengkel.databinding.ActivityMainBinding
import com.example.aplikasiobengkel.databinding.ItemRowMenuBinding
import com.example.aplikasiobengkel.ui.adapter.ArticleAdapter
import com.example.aplikasiobengkel.ui.profile.ProfileActivity
import com.example.aplikasiobengkel.data.model.User
import com.example.aplikasiobengkel.ui.auth.login.LoginActivity
import com.example.aplikasiobengkel.ui.chat.ChatActivity
import com.example.aplikasiobengkel.ui.history.HistoryActivity
import com.example.aplikasiobengkel.ui.promo.PromoActivity
import com.example.aplikasiobengkel.ui.service.crane.CraneActivity
import com.example.aplikasiobengkel.ui.service.repair.RepairActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mapMenuCategory: Map<String, Menu>
    private lateinit var listArticle: List<Article>


    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        mapMenuCategory = viewModel.getMenuCategory()

        binding.rvArticle.setLayoutManager(
            LinearLayoutManager(
                this,
                LinearLayoutManager.HORIZONTAL,
                true
            )
        )

        listArticle = viewModel.getDataArticle()
        setupLayout()
        setupAction()
        setupRecyclerView()

    }

    private fun setupRecyclerView() {
        val mAdapter = ArticleAdapter(listArticle)

        binding.rvArticle.apply {
            adapter = mAdapter
        }
    }

    private fun setupLayout() {
        binding.apply {
            setupModuleCard(Data.REPAIR_MENU, miOption0)
            setupModuleCard(Data.CRANE_MENU, miOption1)
            setupModuleCard(Data.PROFILE_MENU, miOption2)
            setupModuleCard(Data.CHAT_MENU, miOption3)
            setupModuleCard(Data.HISTORY_MENU, miOption4)
        }
    }

    private fun setupModuleCard(mapKey: String, moduleCard: ItemRowMenuBinding) {
        val category = mapMenuCategory[mapKey]
        if (category != null) {
            Glide.with(this@MainActivity)
                .load(category.thumbnail)
                .apply(RequestOptions().override(100, 100))
                .into(moduleCard.ivItemImage)
        }
    }

    private fun setupAction(){
        binding.apply {
            miOption0.miContainer.setOnClickListener{
                val intent = Intent(this@MainActivity, RepairActivity::class.java)
                startActivity(intent)
            }
            miOption1.miContainer.setOnClickListener{
                val intent = Intent(this@MainActivity, CraneActivity::class.java)
                startActivity(intent)
            }
            miOption2.miContainer.setOnClickListener{
                val person = intent.getParcelableExtra<User>(EXTRA_USER) as User
                val intent = Intent(this@MainActivity, ProfileActivity::class.java)
                intent.putExtra(ProfileActivity.EXTRA_USER,person )
                startActivity(intent)
            }

            miOption3.miContainer.setOnClickListener{
                val intent = Intent(this@MainActivity, ChatActivity::class.java)
                startActivity(intent)
            }

            miOption4.miContainer.setOnClickListener{
                val intent = Intent(this@MainActivity, HistoryActivity::class.java)
                startActivity(intent)
            }

            logout.setOnClickListener {
                val intent = Intent(this@MainActivity, LoginActivity::class.java)
                startActivity(intent)
            }
        }
    }

    companion object {
        const val EXTRA_USER = "extra_user"
    }
}