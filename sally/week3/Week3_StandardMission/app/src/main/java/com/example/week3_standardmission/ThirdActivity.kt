package com.example.week3_standardmission

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.week3_standardmission.databinding.FragmentOneBinding
import com.example.week3_standardmission.databinding.FragmentTwoBinding

class ThirdActivity : Fragment() {
    private lateinit var viewbinding:FragmentOneBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        viewbinding = FragmentOneBinding.inflate(layoutInflater)
        return viewbinding.root
    }
}