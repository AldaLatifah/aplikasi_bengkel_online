package com.example.aplikasiobengkel.ui.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aplikasiobengkel.databinding.ActivityPrivacyPolicyBinding
import com.example.aplikasiobengkel.databinding.ActivityTermConditionBinding

class PrivacyPolicyActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPrivacyPolicyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPrivacyPolicyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "Aplikasi O Bengkel"
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}