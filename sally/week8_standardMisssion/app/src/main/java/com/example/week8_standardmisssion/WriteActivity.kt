package com.example.week8_standardmisssion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week8_standardmisssion.databinding.ActivityWriteBinding

class WriteActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityWriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityWriteBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.btnSave.setOnClickListener {
            val mIntent = Intent(this, MainActivity::class.java).apply {
                putExtra("data", viewBinding.tvEditText.text.toString())
            }
            setResult(RESULT_OK, mIntent)
            if(!isFinishing) finish()
        }
    }
}