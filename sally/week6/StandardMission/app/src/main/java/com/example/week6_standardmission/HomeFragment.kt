package com.example.week6_standardmission

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.week6_standardmission.databinding.ActivityMainBinding
import com.example.week6_standardmission.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment: Fragment() {
//    private val viewBinding: FragmentHomeBinding by lazy {
//        FragmentHomeBinding.inflate(layoutInflater)
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentHomeBinding.inflate(layoutInflater).root

//        val mainVPAdapter = MainVPAdapter(FragmentActivity())
//        viewBinding.vpMain.adapter = mainVPAdapter
//
//        val tabTitleArray = arrayOf(
//            "One",
//            "Two"
//        )
//
//        TabLayoutMediator(viewBinding.tabMain, viewBinding.vpMain) { tab, position ->
//            tab.text = tabTitleArray[position]
//        }.attach()
    }
}