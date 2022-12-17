package com.example.aplikasiobengkel.ui.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.aplikasiobengkel.databinding.ActivityChangeProfileBinding
import com.example.aplikasiobengkel.databinding.ActivityCriticismFormBinding

class CriticismFormActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCriticismFormBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCriticismFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonChangeProfile.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)

            Toast.makeText(
                this, "Berhasil Mengirimkan Kritik dan Saran",
                Toast.LENGTH_SHORT
            ).show()
        }

    }
}