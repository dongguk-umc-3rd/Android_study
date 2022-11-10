package com.example.standard2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.standard2.databinding.ActivityMainBinding
import com.example.standard2.databinding.ActivityWriteBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding
    private lateinit var viewBindingNext: ActivityWriteBinding
    private lateinit var getResultText: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        viewBindingNext = ActivityWriteBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val dataList: ArrayList<Data> =arrayListOf()

        dataList.apply{
            add(Data("hello"))
        }

        val dataRVAdaptor = DataRVAdaptor(dataList)

        viewBinding.rvData.adapter= dataRVAdaptor
        viewBinding.rvData.layoutManager= LinearLayoutManager(this)

        getResultText = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val stringContext = result.data?.getStringExtra(viewBindingNext.tvEditText.toString())
                dataList.apply{
                    add(Data(stringContext.toString()))
                }
                Log.d("Tag","add")
                dataRVAdaptor.notifyDataSetChanged()
            }
        }

        viewBindingNext.btnSave.setOnClickListener{
            val intentSave = Intent(this, WriteActivity::class.java)
                getResultText.launch(intentSave)
        }

        viewBinding.add.setOnClickListener{
            val intentAdd = Intent(this, WriteActivity::class.java)
            startActivity(intentAdd)
        }

    }

    override fun onStart() {
        super.onStart()
        Log.d("Tag","onStart")
    }
}