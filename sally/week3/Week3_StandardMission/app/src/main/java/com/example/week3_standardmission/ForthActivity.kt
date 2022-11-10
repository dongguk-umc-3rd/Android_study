package com.example.week3_standardmission

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.week3_standardmission.databinding.FragmentOneBinding
import com.example.week3_standardmission.databinding.FragmentTwoBinding

class ForthActivity : Fragment() {
    private lateinit var viewbinding:FragmentTwoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        viewbinding = FragmentTwoBinding.inflate(layoutInflater)
        return viewbinding.root
    }
}