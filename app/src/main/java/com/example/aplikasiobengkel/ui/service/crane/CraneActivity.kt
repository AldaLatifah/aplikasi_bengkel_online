package com.example.aplikasiobengkel.ui.service.crane

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aplikasiobengkel.data.model.ServiceStation
import com.example.aplikasiobengkel.data.repository.DataRepository
import com.example.aplikasiobengkel.databinding.ActivityCraneBinding
import com.example.aplikasiobengkel.ui.adapter.ServiceStationAdapter

class CraneActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCraneBinding
    private lateinit var listDerek: List<ServiceStation>

    private val repository = DataRepository()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCraneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "Jasa Derek O Bengkel"
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        val manager = LinearLayoutManager(this)
        binding.rvServiceStation.layoutManager = manager

        val itemDecoration = DividerItemDecoration(this, manager.orientation)
        binding.rvServiceStation.addItemDecoration(itemDecoration)

        listDerek = repository.getDataServiceStation()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val mAdapter = ServiceStationAdapter(listDerek)

        mAdapter.setOnItemClickCallback(object : ServiceStationAdapter.OnItemClickCallback{
            override fun onItemClicked(data: ServiceStation) {
                val intent = Intent(this@CraneActivity, CreateCraneActivity::class.java)
                intent.putExtra(CreateCraneActivity.EXTRA_BENGKEL_NAME, data.name)
                startActivity(intent)
            }
        })

        binding.rvServiceStation.apply {
            adapter = mAdapter
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}