package kr.co.hanbit.week3_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kr.co.hanbit.week3_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding
    // lateinit = 나중에 초기화 하겠다 (최대한 빠른 시일내에 초기화 하겠다)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_next.setOnClickListener {
            val text = editText1.text.toString()
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("Data",text)
            startActivity(intent)
        }
    }
}