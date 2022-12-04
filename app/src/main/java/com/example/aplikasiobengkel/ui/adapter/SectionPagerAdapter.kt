package com.example.aplikasiobengkel.ui.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.aplikasiobengkel.ui.history.CraneFragment
import com.example.aplikasiobengkel.ui.history.RepairFragment

class SectionPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity)  {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = RepairFragment()
            1 -> fragment = CraneFragment()
        }
        return fragment as Fragment
    }
}