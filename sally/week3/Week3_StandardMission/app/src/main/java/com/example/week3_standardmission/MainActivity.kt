package com.example.week3_standardmission

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week3_standardmission.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(viewBinding.root)

        viewBinding.btnGoto2.setOnClickListener {
            val intent = Intent(this, FirstActivity::class.java)
            intent.putExtra("sendData",viewBinding.tvEdittext.text.toString());
            startActivity(intent)
            finish()
        }
    }
}