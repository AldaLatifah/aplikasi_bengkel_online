package com.example.aplikasiobengkel.ui.service.repair

import android.content.ContentValues
import android.content.Intent
import android.database.sqlite.SQLiteConstraintException
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.aplikasiobengkel.data.model.Chat
import com.example.aplikasiobengkel.data.model.Repair
import com.example.aplikasiobengkel.databinding.ActivityCreateRepairBinding
import com.example.aplikasiobengkel.ui.auth.register.RegisterActivity
import com.example.aplikasiobengkel.ui.auth.register.RegisterViewModel
import com.example.aplikasiobengkel.ui.main.MainActivity
import com.example.aplikasiobengkel.data.model.User
import com.example.aplikasiobengkel.ui.auth.register.RegisterViewModelFactory

class CreateRepairActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreateRepairBinding
    private var repair: Repair? = null

    private lateinit var viewModel: RepairViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateRepairBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = obtainViewModel(this@CreateRepairActivity)

        setupAction()
    }

    private fun setupAction() {
        binding.buttonKirimRepair.setOnClickListener {
            val name_montir = intent.getStringExtra(EXTRA_NAME_MONTIR)
            val merk = binding.editTextMerk.text.toString().trim()
            val type = binding.editTextType.text.toString().trim()
            val varian = binding.editTextVarian.text.toString().trim()
            val keluhan = binding.editTextKeluhan.text.toString().trim()
            val tanggal = binding.editTextTanggal.text.toString().trim()
            val waktu = binding.editTextWaktu.text.toString().trim()
            val alamat = binding.editTextAlamat.text.toString().trim()

            when{
                merk.isEmpty() -> {
                    binding.textInputLayoutMerk.error = "Masukkan Merk"
                }
                type.isEmpty() -> {
                    binding.textInputLayoutType.error = "Masukkan Type"
                }
                varian.isEmpty() -> {
                    binding.textInputLayoutVarian.error = "Masukkan Varian"
                }
                keluhan.isEmpty() -> {
                    binding.textInputLayoutKeluhan.error = "Masukkan Keluhan"
                }
                tanggal.isEmpty() -> {
                    binding.textInputLayoutTanggal.error = "Masukkan Tanggal"
                }
                waktu.isEmpty() -> {
                    binding.textInputLayoutWaktu.error = "Masukkan Waktu"
                }
                alamat.isEmpty() -> {
                    binding.textInputLayoutAlamat.error = "Masukkan Alamat"
                }

                else -> {
                    try{
                        repair.let{ repair ->
                            repair?.montir_name = name_montir
                            repair?.merk_mobil = merk
                            repair?.type_mobil = type
                            repair?.varian_mobil = varian
                            repair?.keluhan = keluhan
                            repair?.date = tanggal
                            repair?.time = waktu
                            repair?.alamat = alamat
                            repair?.type = "Sedang Berlangsung"
                        }

                        viewModel.insertRepairData(
                            Repair(
                                name_montir,
                                merk,
                                type,
                                varian,
                                keluhan,
                                tanggal,
                                waktu,
                                alamat,
                                "Sedang Berlangsung"
                            )
                        )

                        if (name_montir != null) {
                            viewModel.getMontirName(name_montir)
                        }

                        if (name_montir != null) {
                            viewModel.getIntentionName(name_montir)
                        }

                        viewModel.intentionname.observe(this) {
                            if (it == null) {
                                viewModel.insertChat(
                                    Chat(
                                        name_montir,
                                        "Halo, saya ingin memesan jasa bengkel"
                                    )
                                )
                            }
                        }

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
        }
    }

    private fun obtainViewModel(activity: AppCompatActivity): RepairViewModel {
        val factory = RepairViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory).get(RepairViewModel::class.java)
    }

    companion object{
        const val EXTRA_NAME_MONTIR = "extra_name_montir"
    }
}