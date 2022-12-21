package kr.co.hanbit.week4_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.hanbit.week4_1.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    lateinit var binding:ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.txtSecond.text=intent.getStringExtra("data")
    }
}