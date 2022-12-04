package com.example.aplikasiobengkel.ui.promo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aplikasiobengkel.data.model.Promo
import com.example.aplikasiobengkel.data.repository.DataRepository
import com.example.aplikasiobengkel.databinding.ActivityPromoBinding
import com.example.aplikasiobengkel.ui.adapter.PromoAdapter

class PromoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPromoBinding

    private lateinit var listPromo: List<Promo>

    private val repository = DataRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPromoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "Promo O Bengkel"
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        val manager = LinearLayoutManager(this)
        binding.rvPromo.layoutManager = manager

        val itemDecoration = DividerItemDecoration(this, manager.orientation)
        binding.rvPromo.addItemDecoration(itemDecoration)

        listPromo = repository.getDataPromo()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val mAdapter = PromoAdapter(listPromo)
        binding.rvPromo.apply {
            adapter = mAdapter
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}