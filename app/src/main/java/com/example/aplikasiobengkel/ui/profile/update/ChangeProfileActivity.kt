package com.example.aplikasiobengkel.ui.profile.update

import android.content.Intent
import android.database.sqlite.SQLiteConstraintException
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.aplikasiobengkel.R
import com.example.aplikasiobengkel.data.model.User
import com.example.aplikasiobengkel.databinding.ActivityChangeProfileBinding
import com.example.aplikasiobengkel.databinding.ActivityCreateCraneBinding
import com.example.aplikasiobengkel.ui.auth.login.LoginActivity
import com.example.aplikasiobengkel.ui.auth.login.LoginViewModel
import com.example.aplikasiobengkel.ui.auth.login.LoginViewModelFactory
import com.example.aplikasiobengkel.ui.main.MainActivity
import com.example.aplikasiobengkel.ui.profile.ProfileActivity

class ChangeProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChangeProfileBinding
    private lateinit var viewModel: ChangeProfileViewModel

    private var user: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityChangeProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = obtainViewModel(this@ChangeProfileActivity)

        user = intent.getParcelableExtra(EXTRA_USER)
        binding.editTextName.setText(user?.name)
        binding.editTextUsername.setText(user?.username)
        binding.editTextTelp.setText(user?.telp)
        binding.editTextEmail.setText(user?.email)
        binding.editTextPassword.setText(user?.password)


        setupAction()
    }

    private fun setupAction() {
        binding.buttonChangeProfile.setOnClickListener {
            val name = binding.editTextName.text.toString().trim()
            val username = binding.editTextUsername.text.toString().trim()
            val telp = binding.editTextTelp.text.toString().trim()
            val email = binding.editTextEmail.text.toString().trim()
            val password = binding.editTextPassword.text.toString().trim()
            val id = user?.id

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

                else -> {
                    try{
                        id?.let { it1 ->
                            User(
                                name,
                                username,
                                telp,
                                email,
                                password,
                                it1

                            )
                        }?.let { it2 ->
                            viewModel.update(
                                it2
                            )
                        }
                        Toast.makeText(
                            this, name,
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
        }
    }


    private fun obtainViewModel(activity: AppCompatActivity): ChangeProfileViewModel {
        val factory = ChangeProfileViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory).get(ChangeProfileViewModel::class.java)
    }

    companion object {
        const val EXTRA_USER = "extra_user"
    }
}