package com.example.aplikasiobengkel.ui.auth.register

import android.content.Intent
import android.database.sqlite.SQLiteConstraintException
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.aplikasiobengkel.databinding.ActivityRegisterBinding
import com.example.aplikasiobengkel.ui.auth.login.LoginActivity
import com.example.aplikasiobengkel.ui.auth.login.LoginViewModel
import com.example.aplikasiobengkel.ui.auth.login.LoginViewModelFactory
import com.example.aplikasiobengkel.ui.main.MainActivity
import com.example.aplikasiobengkel.data.model.User

class RegisterActivity : AppCompatActivity() {
    private var user: User? = null
    private var _binding: ActivityRegisterBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        viewModel = obtainViewModel(this@RegisterActivity)

        setupAction()
    }

    private fun setupAction() {
        binding.buttonRegister.setOnClickListener {
            val name = binding.editTextName.text.toString().trim()
            val username = binding.editTextUsername.text.toString().trim()
            val telp = binding.editTextTelp.text.toString().trim()
            val email = binding.editTextEmail.text.toString().trim()
            val password = binding.editTextPassword.text.toString().trim()
            val confirm = binding.editTextConfirm.text.toString().trim()

            when{
                name.isEmpty() -> {
                    binding.textInputLayoutName.error = "Masukkan Nama"
                }
                username.isEmpty() -> {
                    binding.textInputLayoutUsername.error = "Masukkan Username"
                }
                telp.isEmpty() -> {
                    binding.textInputLayoutTelp.error = "Masukkan No Telepon"
                }
                email.isEmpty() -> {
                    binding.textInputLayoutEmail.error = "Masukkan Email"
                }
                password.isEmpty() -> {
                    binding.textInputLayoutPassword.error = "Masukkan Password"
                }

                confirm.isEmpty()->{
                    binding.textInputLayoutConfirm.error = "Masukkan Konfirmasi"
                }

                password != confirm ->{
                    binding.textInputLayoutConfirm.error = "Konfirmasi Password Salah"
                }

                else -> {
                    viewModel.checkEmail(email)
                }
            }
        }

        viewModel.account.observe(this) {
            if (it != null) {
                binding.textInputLayoutEmail.error = "Email Sudah Digunakan"
            } else {
                val name = binding.editTextName.text.toString().trim()
                val username = binding.editTextUsername.text.toString().trim()
                val telp = binding.editTextTelp.text.toString().trim()
                val email = binding.editTextEmail.text.toString().trim()
                val password = binding.editTextPassword.text.toString().trim()
                try{
                    user.let{ user ->
                        user?.name = name
                        user?.username = username
                        user?.telp = telp
                        user?.email = email
                        user?.password = password
                    }

                    viewModel.register(
                        User(
                            name,
                            username,
                            telp,
                            email,
                            password
                        )
                    )
                    Toast.makeText(
                        this,
                        "Berhasil menambah data",
                        Toast.LENGTH_SHORT
                    ).show()
                    finish()
                }catch (
                    e: SQLiteConstraintException
                ) {
                    e.printStackTrace()
                }
            }
        }

        binding.buttonLogin.setOnClickListener {
            val registerIntent = Intent(this, LoginActivity::class.java)
            startActivity(registerIntent)
        }
    }

    private fun obtainViewModel(activity: AppCompatActivity): RegisterViewModel {
        val factory = RegisterViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory).get(RegisterViewModel::class.java)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}