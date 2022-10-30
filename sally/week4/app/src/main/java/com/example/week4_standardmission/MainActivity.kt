package com.example.week4_standardmission

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.week4_standardmission.databinding.ActivityMainBinding

lateinit var edittext_pause : String

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding:ActivityMainBinding
    private var memoContext: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.btnSave.setOnClickListener {
            val intent = Intent(this,SecondActivity::class.java)
            intent.putExtra("Data",viewBinding.tvEditText.text.toString())
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("Lifecycle","onStart")
        val showToast = Toast.makeText(this, "메모 작성",Toast.LENGTH_LONG)
        showToast.show()
    }

    override fun onStop() {
        super.onStop()
        Log.d("Lifecycle","onStop")
        memoContext = viewBinding.tvEditText.text.toString()
        viewBinding.tvEditText.setText("")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Lifecycle","onResume")

    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Lifecycle","onRestart")
        AlertDialog.Builder(this)
            .setMessage("계속 작성하시겠습니까?")
            .setPositiveButton("예") {dialog,which->
                viewBinding.tvEditText.setText(memoContext)
            }
            .setNegativeButton("아니요"){dialog,which->
                viewBinding.tvEditText.text.clear()
            }
            .create()
            .show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Lifecycle","onDestroy")
    }

    //    override fun onPause() {
//        super.onPause()
//        Log.d("Lifecycle","onPause")
//        viewBinding = ActivityMainBinding.inflate(layoutInflater)
//
//        setContentView(viewBinding.root)
//
//        val untiltext = viewBinding.tvEditText.text.toString()
//        edittext_pause = untiltext
//    }
}