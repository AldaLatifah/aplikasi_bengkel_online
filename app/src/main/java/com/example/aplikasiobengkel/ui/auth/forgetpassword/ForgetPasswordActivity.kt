package com.example.aplikasiobengkel.ui.auth.forgetpassword

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.aplikasiobengkel.R
import com.example.aplikasiobengkel.data.model.User
import com.example.aplikasiobengkel.databinding.ActivityForgetPasswordBinding
import com.example.aplikasiobengkel.databinding.ActivityLoginBinding
import com.example.aplikasiobengkel.ui.auth.login.LoginActivity
import com.example.aplikasiobengkel.ui.auth.login.LoginViewModel
import com.example.aplikasiobengkel.ui.auth.login.LoginViewModelFactory
import com.example.aplikasiobengkel.ui.auth.register.RegisterActivity
import com.example.aplikasiobengkel.ui.main.MainActivity

class ForgetPasswordActivity : AppCompatActivity() {

    private var _binding: ActivityForgetPasswordBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: ForgetPasswordViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityForgetPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "Lupa Sandi"
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        viewModel = obtainViewModel(this@ForgetPasswordActivity)

        setupAction()

    }

    private fun setupAction() {
        binding.buttonForget.setOnClickListener {
            val email = binding.txtEmail.text.toString()
            val password = binding.txtPassword.text.toString()
            val confirm = binding.txtConfirmPassword.text.toString()

            when{
                email.isEmpty() -> {
                    binding.layoutEmail.error = "Masukkan email"
                }
                password.isEmpty() -> {
                    binding.layoutPassword.error = "Masukkan password"
                }

                confirm.isEmpty()->{
                    binding.layoutConfirmPassword.error = "Masukkan Konfirmasi"
                }

                password != confirm ->{
                    binding.txtConfirmPassword.error = "Konfirmasi Password Salah"
                }
                else -> {
                    viewModel.checkEmail(binding.txtEmail.text.toString())
                }
            }
        }

        viewModel.account.observe(this) {
            if (it != null) {
                viewModel.updatePassword(it.email, it.password)

                val registerIntent = Intent(this, LoginActivity::class.java)
                startActivity(registerIntent)

            } else {
                binding.txtEmail.error = "Email not found"
            }
        }

    }

    private fun obtainViewModel(activity: AppCompatActivity): ForgetPasswordViewModel {
        val factory = ForgetPasswordViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory).get(ForgetPasswordViewModel::class.java)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}