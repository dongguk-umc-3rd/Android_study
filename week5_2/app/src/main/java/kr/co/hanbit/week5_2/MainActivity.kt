package kr.co.hanbit.week5_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import kr.co.hanbit.week5_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var getResultText: ActivityResultLauncher<Intent>

    private val dataList: ArrayList<Data> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val dataRVAdapter = DataRVAdapter(dataList, onClickDeleteBtn = {
            deleteTask(it)
        })


        getResultText =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == RESULT_OK) {
                    val mString = result.data?.getStringExtra("data") ?: ""
                    Log.d("TAG", "onCreate: $mString")

                    dataList.apply {
                        add(Data("$mString"))
                    }
                    dataRVAdapter.notifyItemRangeInserted(dataList.size, 1) // 변경된 아이템의 시작 위치, 변경된 아이템 개수
                }
            }

        binding.btnAdd.setOnClickListener {
            val mintent = Intent(this@MainActivity, MemoActivity::class.java)
            getResultText.launch(mintent)
        }

        binding.rvData.adapter = dataRVAdapter
        binding.rvData.layoutManager = LinearLayoutManager(this)

    }
    fun deleteTask(data: Data) {
        dataList.remove(data)
        binding.rvData.adapter?.notifyDataSetChanged()
    }
}