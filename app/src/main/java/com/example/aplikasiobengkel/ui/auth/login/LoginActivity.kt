package com.example.aplikasiobengkel.ui.auth.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.aplikasiobengkel.data.model.User
import com.example.aplikasiobengkel.databinding.ActivityLoginBinding
import com.example.aplikasiobengkel.ui.auth.forgetpassword.ForgetPasswordActivity
import com.example.aplikasiobengkel.ui.auth.register.RegisterActivity
import com.example.aplikasiobengkel.ui.main.MainActivity


class LoginActivity : AppCompatActivity() {

    private var _binding: ActivityLoginBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        viewModel = obtainViewModel(this@LoginActivity)
        setupAction()
    }

    private fun setupAction() {
        binding.buttonLogin.setOnClickListener {
            val email = binding.txtEmail.text.toString()
            val password = binding.txtPassword.text.toString()

            when{
                email.isEmpty() -> {
                    binding.layoutEmail.error = "Masukkan email"
                }
                password.isEmpty() -> {
                    binding.layoutPassword.error = "Masukkan password"
                }
                else -> {
                    viewModel.login(binding.txtEmail.text.toString())
                }
            }
        }

        viewModel.account.observe(this) {
            if (it != null) {
                if (binding.txtPassword.text.toString() == it.password) {
                    val person = User(
                        it.name,
                        it.username,
                        it.telp,
                        it.email,
                        it.password,
                        it.id
                    )
                    val moveWithObjectIntent = Intent(this, MainActivity::class.java)
                    moveWithObjectIntent.putExtra(MainActivity.EXTRA_USER, person)
                    moveWithObjectIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    startActivity(moveWithObjectIntent)
                } else {
                    binding.txtPassword.error = "Password is incorrect"
                }
            } else {
                binding.txtEmail.error = "Username not found"
            }
        }
        binding.buttonRegister.setOnClickListener {
            val registerIntent = Intent(this, RegisterActivity::class.java)
            startActivity(registerIntent)
        }

    }

    private fun obtainViewModel(activity: AppCompatActivity): LoginViewModel {
        val factory = LoginViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory).get(LoginViewModel::class.java)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}