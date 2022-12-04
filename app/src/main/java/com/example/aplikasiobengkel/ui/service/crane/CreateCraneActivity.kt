package com.example.aplikasiobengkel.ui.service.crane

import android.database.sqlite.SQLiteConstraintException
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.aplikasiobengkel.data.model.Chat
import com.example.aplikasiobengkel.data.model.Crane
import com.example.aplikasiobengkel.data.model.Repair
import com.example.aplikasiobengkel.databinding.ActivityCreateCraneBinding
import com.example.aplikasiobengkel.ui.service.repair.CreateRepairActivity
import com.example.aplikasiobengkel.ui.service.repair.RepairViewModel
import com.example.aplikasiobengkel.ui.service.repair.RepairViewModelFactory

class CreateCraneActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreateCraneBinding
    private lateinit var viewModel: CraneViewModel

    private var crane: Crane? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateCraneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = obtainViewModel(this@CreateCraneActivity)

        setupAction()
    }

    private fun setupAction() {
        binding.buttonKirimCrane.setOnClickListener {
            val bengkel_name = intent.getStringExtra(EXTRA_BENGKEL_NAME)
            val merk = binding.editTextMerk.text.toString().trim()
            val type = binding.editTextType.text.toString().trim()
            val varian = binding.editTextVarian.text.toString().trim()
            val lokasi = binding.editTextLokasi.text.toString().trim()
            val lokasiTujuan = binding.editTextLokasiTujuan.text.toString().trim()
            val keterangan = binding.editTextKeterangan.text.toString().trim()

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
                lokasi.isEmpty() -> {
                    binding.textInputLayoutLokasi.error = "Masukkan Keluhan"
                }
                lokasiTujuan.isEmpty() -> {
                    binding.textInputLayoutLokasiTujuan.error = "Masukkan Tanggal"
                }

                else -> {
                    try{
                        crane.let{ crane ->
                            crane?.bengkel_name = bengkel_name
                            crane?.merk_mobil = merk
                            crane?.type_mobil = type
                            crane?.varian_mobil = varian
                            crane?.lokasi = lokasi
                            crane?.lokasi_tujuan = lokasiTujuan
                            crane?.keterangan = keterangan
                            crane?.type = "Sedang Berlangsung"
                        }

                        viewModel.insertCraneData(
                            Crane(
                                bengkel_name,
                                merk,
                                type,
                                varian,
                                lokasi,
                                lokasiTujuan,
                                keterangan,
                                "Sedang Berlangsung"
                            )
                        )

                        if (bengkel_name != null) {
                            viewModel.getIntentionName(bengkel_name)
                        }

                        viewModel.intentionname.observe(this) {
                            if (it == null) {
                                viewModel.insertChat(
                                    Chat(
                                        bengkel_name,
                                        "Halo, saya ingin memesan jasa derek"
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

    private fun obtainViewModel(activity: AppCompatActivity): CraneViewModel {
        val factory = CraneViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory).get(CraneViewModel::class.java)
    }


    companion object{
        const val EXTRA_BENGKEL_NAME = "extra_bengkel_name"
    }
}