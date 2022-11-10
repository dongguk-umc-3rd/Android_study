package com.example.week3_standardmission

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.week3_standardmission.databinding.ActivityFirstBinding
import com.example.week3_standardmission.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySecondBinding.inflate(layoutInflater)

        setContentView(viewBinding.root)

        //기본화면 설정
        supportFragmentManager
            .beginTransaction()  //fragment 연결 시작
            .replace(viewBinding.frameFragment.id, ThirdActivity())
            .commitAllowingStateLoss()   //데이터 저장하는 경우 없을 때

        viewBinding.btnGotofragment1.setOnClickListener {
            supportFragmentManager
                .beginTransaction()  //fragment 연결 시작
                .replace(viewBinding.frameFragment.id, ThirdActivity())
                .commitAllowingStateLoss()
        }

        viewBinding.btnGotofragment2.setOnClickListener {
            supportFragmentManager
                .beginTransaction()  //fragment 연결 시작
                .replace(viewBinding.frameFragment.id, ForthActivity())
                .commitAllowingStateLoss()
        }

    }
}