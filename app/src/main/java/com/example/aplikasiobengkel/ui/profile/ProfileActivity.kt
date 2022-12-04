package com.example.aplikasiobengkel.ui.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.aplikasiobengkel.data.local.Data
import com.example.aplikasiobengkel.data.model.Profile
import com.example.aplikasiobengkel.databinding.ActivityProfileBinding
import com.example.aplikasiobengkel.databinding.ItemRowProfileMenuBinding
import com.example.aplikasiobengkel.data.model.User
import com.example.aplikasiobengkel.ui.main.MainActivity
import com.example.aplikasiobengkel.ui.profile.update.ChangeProfileActivity
import com.example.aplikasiobengkel.ui.promo.PromoActivity
import com.example.aplikasiobengkel.ui.service.crane.CraneActivity
import com.example.aplikasiobengkel.ui.service.crane.CraneViewModel
import com.example.aplikasiobengkel.ui.service.crane.CraneViewModelFactory
import com.example.aplikasiobengkel.ui.service.repair.RepairActivity

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    private lateinit var mapMenuCategory: Map<String, Profile>
    private lateinit var viewModel: ProfileViewModel
//    private val viewModel by viewModels<ProfileViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "Profile Data Diri"
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        val person = intent.getParcelableExtra<User>(EXTRA_USER) as User

        viewModel = obtainViewModel(this@ProfileActivity)
        mapMenuCategory = viewModel.getProfileCategory()

        viewModel.checkEmail(person.email)

        viewModel.account.observe(this) {
            if (it != null) {
                binding.tvName.text = it.name
                binding.tvEmail.text = it.email
                binding.tvTelp.text = it.telp
            }
        }
        setupLayout()
        setupAction()
    }

    private fun setupLayout() {
        binding.apply {
            setupModuleCard(Data.TERM_CONDITIONS_MENU, termCondition)
            setupModuleCard(Data.PRIVACY_POLICY_MENU, privacyPolicy)
            setupModuleCard(Data.CONTACT_US_MENU, contactUs)
        }
    }

    private fun setupAction(){
        binding.apply {
            changeProfile.cardViewProfile.setOnClickListener{
                val person = intent.getParcelableExtra<User>(EXTRA_USER) as User
                val intent = Intent(it.context, ChangeProfileActivity::class.java)
                intent.putExtra(ChangeProfileActivity.EXTRA_USER,person )
                it.context.startActivity(intent)
            }
            termCondition.cardViewProfile.setOnClickListener{
                val intent = Intent(this@ProfileActivity, TermConditionActivity::class.java)
                startActivity(intent)
            }
            privacyPolicy.cardViewProfile.setOnClickListener{
                val intent = Intent(this@ProfileActivity, PrivacyPolicyActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun setupModuleCard(mapKey: String, moduleCard: ItemRowProfileMenuBinding) {
        val category = mapMenuCategory[mapKey]
        if (category != null) {
            Glide.with(this@ProfileActivity)
                .load(category.thumbnail)
                .apply(RequestOptions().override(100, 100))
                .into(moduleCard.imageItemProfile)
            moduleCard.tvTitleProfile.text = category.title
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun obtainViewModel(activity: AppCompatActivity): ProfileViewModel {
        val factory = ProfileViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory).get(ProfileViewModel::class.java)
    }

    companion object {
        const val EXTRA_USER = "extra_user"
    }
}