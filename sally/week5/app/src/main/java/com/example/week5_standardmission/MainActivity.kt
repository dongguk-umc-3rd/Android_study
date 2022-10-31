package com.example.week5_standardmission

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.SparseBooleanArray
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week5_standardmission.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val dataList: ArrayList<Data> = arrayListOf()


        dataList.apply {
            add(Data("hello","1"))
            add(Data("hello","2"))
            add(Data("hello","3"))
            add(Data("hello","4"))
            add(Data("hello","5"))
            add(Data("hello","6"))
            add(Data("hello","7"))
            add(Data("hello","8"))
            add(Data("hello","9"))
            add(Data("hello","10"))
            add(Data("hello","11"))
            add(Data("hello","12"))
            add(Data("hello","13"))
            add(Data("hello","14"))
            add(Data("hello","15"))
            add(Data("hello","16"))
            add(Data("hello","17"))
            add(Data("hello","18"))
            add(Data("hello","19"))
            add(Data("hello","20"))

        }

        val dataRVAdaptor = DataRVAdaptor(dataList)

        viewBinding.rvData.adapter = dataRVAdaptor
        viewBinding.rvData.layoutManager = LinearLayoutManager(this)
    }
}
