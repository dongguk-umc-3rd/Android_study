package kr.co.hanbit.week3_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import kotlinx.android.synthetic.main.activity_second.*
import kr.co.hanbit.week3_2.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        tv_secondtext.text=intent.getStringExtra("Data")

        viewBinding.btnNextA3.setOnClickListener {
            val intent=Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }
    }
}