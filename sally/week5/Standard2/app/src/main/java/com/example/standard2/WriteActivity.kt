package com.example.standard2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.standard2.databinding.ActivityWriteBinding

class WriteActivity : AppCompatActivity() {
    private lateinit var viewBinding:ActivityWriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityWriteBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.btnSave.setOnClickListener{
            val intentSave = Intent(this, MainActivity::class.java)
            setResult(RESULT_OK, intentSave)
            finish()
        }
    }
}