package kr.co.hanbit.week4_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kr.co.hanbit.week4_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var memo: String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        binding.btnMain.setOnClickListener {
            var intent=Intent(this, SecondActivity::class.java)
            intent.putExtra("data", binding.edtMain.text.toString())
            startActivity(intent)
        }

        val create= Toast.makeText(this.applicationContext,"onCreate 실행",Toast.LENGTH_SHORT)
        create.show()
    }

    override fun onStop() {
        super.onStop()
        memo=binding.edtMain.text.toString()
        binding.edtMain.text.clear()

        val stop=Toast.makeText(this.applicationContext,"onStop 실행", Toast.LENGTH_SHORT)
        stop.show()
    }

    override fun onRestart() {
        super.onRestart()
        AlertDialog.Builder(this)
            .setTitle("알림")
            .setMessage("계속 작성하시겠습니까?")
            .setPositiveButton("네") {dialog,which->
                binding.edtMain.setText(memo)
            }
            .setNegativeButton("아니요"){dialog,which->
                binding.edtMain.text.clear()
            }
            .create()
            .show()

        val restart=Toast.makeText(this.applicationContext,"onRestart 실행",Toast.LENGTH_SHORT)
        restart.show()
    }
}