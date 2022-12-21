package kr.co.hanbit.week3_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kr.co.hanbit.week3_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_next.setOnClickListener {
            val text = editText1.text.toString()
            val intent=Intent(this, SecondActivity::class.java)
            intent.putExtra("Data",text)
            startActivity(intent)
        }
    }
}