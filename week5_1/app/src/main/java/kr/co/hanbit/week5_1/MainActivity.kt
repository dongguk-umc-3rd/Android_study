package kr.co.hanbit.week5_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kr.co.hanbit.week5_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val dataList: ArrayList<MainData> = arrayListOf()

        dataList.apply {
            add(MainData("UMC week 5","1"))
            add(MainData("UMC week 5","2"))
            add(MainData("UMC week 5","3"))
            add(MainData("UMC week 5","4"))
            add(MainData("UMC week 5","5"))
            add(MainData("UMC week 5","6"))
            add(MainData("UMC week 5","7"))
            add(MainData("UMC week 5","8"))
            add(MainData("UMC week 5","9"))
            add(MainData("UMC week 5","10"))

        }

        val mainRVAdapter=MainRVAdapter(dataList)

        viewBinding.rvData.adapter=mainRVAdapter
        viewBinding.rvData.layoutManager=LinearLayoutManager(this)
    }
}