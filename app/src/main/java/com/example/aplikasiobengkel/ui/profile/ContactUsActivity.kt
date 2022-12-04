package com.example.aplikasiobengkel.ui.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aplikasiobengkel.databinding.ActivityContactUsBinding
import com.example.aplikasiobengkel.databinding.ActivityPrivacyPolicyBinding

class ContactUsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityContactUsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactUsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "Hubungi Kami"
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}