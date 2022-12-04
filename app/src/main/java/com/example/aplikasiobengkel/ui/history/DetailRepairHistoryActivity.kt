package com.example.aplikasiobengkel.ui.history

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aplikasiobengkel.data.model.Crane
import com.example.aplikasiobengkel.data.model.Repair
import com.example.aplikasiobengkel.databinding.ActivityDetailCraneHistoryBinding
import com.example.aplikasiobengkel.databinding.ActivityDetailRepairHistoryBinding
import com.example.aplikasiobengkel.ui.chat.ChatActivity

class DetailRepairHistoryActivity : AppCompatActivity() {
    private var _binding: ActivityDetailRepairHistoryBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailRepairHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "Detail Riwayat"
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        val repair = intent.getParcelableExtra<Repair>(EXTRA_REPAIR) as Repair
        binding.editTextMerk.setText(repair.merk_mobil)
        binding.editTextType.setText(repair.type_mobil)
        binding.editTextVarian.setText(repair.varian_mobil)
        binding.editTextKeluhan.setText(repair.keluhan)
        binding.editTextTanggal.setText(repair.date)
        binding.editTextWaktu.setText(repair.time)
        binding.editTextAlamat.setText(repair.alamat)
        binding.editNoHpMontir.setText("087865681028")

        binding.buttonChat.setOnClickListener {
            val registerIntent = Intent(this, ChatActivity::class.java)
            startActivity(registerIntent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    companion object{
        const val EXTRA_REPAIR = "extra_repair"
    }
}