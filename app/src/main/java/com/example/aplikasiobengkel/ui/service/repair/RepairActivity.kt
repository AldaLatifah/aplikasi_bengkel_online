package com.example.aplikasiobengkel.ui.service.repair

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aplikasiobengkel.data.model.Mechanic
import com.example.aplikasiobengkel.data.repository.DataRepository
import com.example.aplikasiobengkel.databinding.ActivityRepairBinding
import com.example.aplikasiobengkel.ui.adapter.MechanicAdapter
import com.example.aplikasiobengkel.ui.profile.ProfileViewModel

class RepairActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRepairBinding
    private var listReview: ArrayList<Mechanic> = ArrayList()
    private lateinit var adapter: MechanicAdapter

    private lateinit var listMontir: List<Mechanic>

    private val repository = DataRepository()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRepairBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "Jasa Reparasi O Bengkel"
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        val manager = LinearLayoutManager(this)
        binding.rvMechanic.layoutManager = manager

        val itemDecoration = DividerItemDecoration(this, manager.orientation)
        binding.rvMechanic.addItemDecoration(itemDecoration)

        listMontir = repository.getDataMechanic()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val mAdapter = MechanicAdapter(listMontir)

        mAdapter.setOnItemClickCallback(object : MechanicAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Mechanic) {
                val intent = Intent(this@RepairActivity, CreateRepairActivity::class.java)
                intent.putExtra(CreateRepairActivity.EXTRA_NAME_MONTIR, data.name)
                startActivity(intent)
            }
        })
        binding.rvMechanic.apply {
            adapter = mAdapter
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}