package kr.co.hanbit.week8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import kr.co.hanbit.week8.Recycler.MemoRVAdapter
import kr.co.hanbit.week8.Room.AppDatabase
import kr.co.hanbit.week8.Room.Memo
import kr.co.hanbit.week8.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var getResultText: ActivityResultLauncher<Intent>

    private val memoList: ArrayList<Memo> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val roomDb = AppDatabase.getInstance(this)


        if (roomDb != null) {
            val savedMemo = roomDb.memoDao().selectAll()
            memoList.addAll(savedMemo)
        }

        val dataRVAdapter = MemoRVAdapter(memoList, onClickDeleteBtn = {
            if (roomDb != null) {
                roomDb.memoDao().delete(it)
            }
            deleteTask(it)
        })

        getResultText =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == RESULT_OK) {
                    if (roomDb != null) {
                        val mString = result.data?.getStringExtra("data") ?: ""

                        val memo = Memo("${mString}")
                        roomDb.memoDao().insert(memo)

                        memoList.apply {
                            add(Memo("$mString"))
                        }

                        dataRVAdapter.notifyItemRangeInserted(memoList.size, 1)
                    }
                }
            }


        binding.btnAdd.setOnClickListener {
            val mintent = Intent(this@MainActivity, MemoActivity::class.java)
            getResultText.launch(mintent)
        }

        binding.rvData.adapter = dataRVAdapter
        binding.rvData.layoutManager = LinearLayoutManager(this)
    }

    fun deleteTask(data: Memo) {
        memoList.remove(data)
        binding.rvData.adapter?.notifyDataSetChanged()
    }
}