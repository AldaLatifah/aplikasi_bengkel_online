package com.example.aplikasiobengkel.ui.history

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aplikasiobengkel.R
import com.example.aplikasiobengkel.data.model.Crane
import com.example.aplikasiobengkel.data.model.User
import com.example.aplikasiobengkel.databinding.ActivityDetailCraneHistoryBinding
import com.example.aplikasiobengkel.databinding.ActivityLoginBinding
import com.example.aplikasiobengkel.ui.auth.login.LoginActivity
import com.example.aplikasiobengkel.ui.chat.ChatActivity
import com.example.aplikasiobengkel.ui.profile.ProfileActivity
import com.example.aplikasiobengkel.ui.profile.update.ChangeProfileActivity

class DetailCraneHistoryActivity : AppCompatActivity() {

    private var _binding: ActivityDetailCraneHistoryBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailCraneHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "Detail Riwayat"
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        val crane = intent.getParcelableExtra<Crane>(DetailCraneHistoryActivity.EXTRA_CRANE) as Crane
        binding.editTextMerk.setText(crane.merk_mobil)
        binding.editTextType.setText(crane.type_mobil)
        binding.editTextVarian.setText(crane.varian_mobil)
        binding.editTextLokasi.setText(crane.lokasi)
        binding.editTextLokasiTujuan.setText(crane.lokasi_tujuan)
        binding.editTextKeterangan.setText(crane.keterangan)
        binding.editNoHpMontir.setText("082981192028")

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
        const val EXTRA_CRANE = "extra_crane"
    }
}