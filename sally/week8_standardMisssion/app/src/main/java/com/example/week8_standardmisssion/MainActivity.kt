package com.example.week8_standardmisssion

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week8_standardmisssion.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var getResultText: ActivityResultLauncher<Intent>
    private val memoList: ArrayList<User> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // DB 초기화
        val roomDb = AppDatabase.getInstance(this)

        // 이전에 저장한 내용 모두 불러와서 추가하기
        if(roomDb != null) {
            val savedMemo = roomDb.UserDao().selectAll()
            memoList.addAll(savedMemo)
        }

        // position 을 전달받고 삭제 함수 실행
        val dataRVAdapter = DataRVAdaptor(memoList, onClickDeleteBtn = {
            if (roomDb != null) { // DB 에서 삭제
                roomDb.UserDao().delete(it)
            }
            deleteTask(it) // 리스트뷰에서 삭제
        })

        // ActivityResult 를 받기 위한 Callback 등록
        getResultText =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == RESULT_OK) {
                    if(roomDb != null) {
                        val mString = result.data?.getStringExtra("data") ?: ""
                        // DB 에 삽입
                        val memo = User("${mString}")
                        roomDb.UserDao().insert(memo)
                        // 리스트뷰에 삽입
                        memoList.apply {
                            add(User("$mString"))
                        }
                        // 리스트뷰 갱신
                        dataRVAdapter.notifyItemRangeInserted(memoList.size, 1) // 변경된 아이템의 시작 위치, 변경된 아이템 개수
                    }
                }
            }

        // 메모 추가 버튼 누르면 메모 화면으로 넘어가는 것 && 위에서 정의한 것을 launch 함수로 시작
        binding.add.setOnClickListener {
            val mintent = Intent(this@MainActivity, WriteActivity::class.java)
            getResultText.launch(mintent)
        }

        binding.rvData.adapter = dataRVAdapter // 리사이클러뷰에 어댑터 연결
        binding.rvData.layoutManager = LinearLayoutManager(this) // 레이아웃 매니저 연결
    }

    fun deleteTask(data: User) {
        memoList.remove(data)
        binding.rvData.adapter?.notifyDataSetChanged()
    }

//        //name에 package name 적어줘야해서 packagename 이라고 적어도 됨.
//        val sharedPrefs = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
//        //edit : SharedPreference 값 수정하는 역할
//        val editor = sharedPrefs.edit()
//
//        editor.putString("sally","android")
//        //apply 해줘야 반영됨.
//        editor.apply()
//
//        //가져올 때
//
//        //해당 값이 아닐 때 무슨 값 가져올지 설정 필요 : ""빈값 넣어줌
//       val spvalue = sharedPrefs.getString("sally","")
//        Log.d("SP","${spvalue}")
//
//        val roomDb = AppDatabase.getInstance(this)
//
//        if (roomDb != null){
//            val deleteUser = User("",0,2)
//            roomDb.UserDao().delete(deleteUser)
////            val user = User("sally",23)
////            roomDb.UserDao().insert(user)
//
//            val userList = roomDb.UserDao().selectAll()
//            Log.d("DB","User List : ${userList}")
//        }
    }
