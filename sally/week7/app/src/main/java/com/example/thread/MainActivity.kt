package com.example.thread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import com.example.thread.databinding.ActivityMainBinding
import java.util.*
import kotlin.concurrent.thread
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {
    var time = 0L
    var temptime = 0L
    var timerTask : Timer? = null

    var timerRunning = false  // 타이머 실행 상태
    var firstState = false    // 타이머 실행 처음인지 아닌지

    lateinit var viewBinding : ActivityMainBinding
    lateinit var countDownTimer: CountDownTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.btnStart.setOnClickListener {
            viewMode("start")
            startStop()
        }

        viewBinding.btnPause.setOnClickListener {
            startStop()
        }

        viewBinding.btnRestart.setOnClickListener {
            viewMode("cancel")
            stopTimer()
        }
    }

//    private fun startTimer() {
//        timerTask = timer(period = 1000) {
//            time++
//
//            val sec = time
//        }
//    }

    private fun viewMode(mode: String){
        firstState = true

        if (mode == "start"){  //타이머 시작
            viewBinding.countSet.visibility = View.GONE
            viewBinding.timer.visibility = View.VISIBLE
        } else {  //시간 설정
            viewBinding.countSet.visibility = View.VISIBLE
            viewBinding.timer.visibility = View.GONE
        }
    }

    private fun startStop() {
        if (timerRunning) {
            stopTimer()
        } else {
            startTimer()
        }
    }

    private fun startTimer(){
        //처음 실행이면 입력값을 타이머 설정값으로 사용
        if (firstState) {
            val sHour = viewBinding.HourSet.text.toString()
            val sMin = viewBinding.MinSet.text.toString()
            val sSec = viewBinding.SecSet.text.toString()

            time = (sHour.toLong() * 3600000) + (sMin.toLong() * 60000) + (sSec.toLong() * 1000) + 1000
        } else {  // 정지 후 이어 실행이면 기존 시간 사용
            time = temptime
        }

        //타이머 실행
//        thread(start = true){
//            Thread.sleep(1000)
//            temptime = temptime - 1000
//            print("************* $temptime")
//        }
//        Thread() {
//            //while (time.toInt() != 0){
//                print("************* $temptime")
//                temptime = temptime - 1
//                updateTime()
//                Thread.sleep(1000)
//            //}
//        }.start()
        countDownTimer = object: CountDownTimer(time,1000){
            override fun onTick(millisUnitFinished: Long) {
                temptime = millisUnitFinished
                updateTime()
            }
            override fun onFinish() {}
        }.start()

        viewBinding.btnPause.text = "일시 정지"
        timerRunning =true
        firstState = false
    }

    private fun stopTimer(){
        //countDownTimer.cancel()
        timerRunning = false
        viewBinding.btnPause.text = "계속"

    }

    private fun updateTime(){
        val hour = temptime / 3600000
        val min = temptime % 3600000 / 60000
        val sec = temptime % 3600000 % 60000 / 1000

        //시간 추가
        var timeLeftText = "$hour : "

        //분이 10보다 작으면 0 붙이기
        if(min < 10) timeLeftText += "0"

        //분 추가
        timeLeftText += "$min :"

        //초가 10보다 작으면 0 붙이기
        if(sec < 10) timeLeftText += "0"

        //초 추가
        timeLeftText += sec

        //타이머 텍스트 보여주기
        viewBinding.show.text = timeLeftText
    }
}