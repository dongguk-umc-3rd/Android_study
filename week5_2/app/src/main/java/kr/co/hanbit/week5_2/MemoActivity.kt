package kr.co.hanbit.week5_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.hanbit.week5_2.databinding.ActivityMemoBinding

class MemoActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMemoBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.btnStore.setOnClickListener {
            val mIntent = Intent(this, MainActivity::class.java).apply {
                putExtra("data", viewBinding.edtText.text.toString())
            }
            setResult(RESULT_OK, mIntent)
            if(!isFinishing) finish()
        }
    }
}