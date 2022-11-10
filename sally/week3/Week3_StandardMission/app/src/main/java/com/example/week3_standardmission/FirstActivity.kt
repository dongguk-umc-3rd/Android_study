package com.example.week3_standardmission

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.week3_standardmission.databinding.ActivityFirstBinding
import com.example.week3_standardmission.databinding.ActivityMainBinding

class FirstActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityFirstBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityFirstBinding.inflate(layoutInflater)

        setContentView(viewBinding.root)

        val extras = intent.extras
        val data = extras!!["sendData"] as String

        viewBinding.tvSecondpage.text = data

        viewBinding.btnGoto3.setOnClickListener {
            val intent2 = Intent(this, SecondActivity::class.java)
            startActivity(intent2)
        }

    }
}