package com.bh.lotto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lotteryNumbs = arrayListOf(number1, number2, number3, number4, number5, number6)

        val countDownTimer = object: CountDownTimer(2000,100){
            override fun onTick(millisUntilFinished: Long) {
                lotteryNumbs.forEach{
                    val randomNumber = (Math.random() * 45 + 1).toInt()
                    it.text = "$randomNumber"
                }
            }

            override fun onFinish() {
            }
        }

        lotteryBtn.setOnClickListener{
            /* moved to the timer ontop
            lotteryNumbs.forEach{
                val randomNumber = (Math.random() * 45 + 1).toInt()
                it.text = "$randomNumber"
            }
            */

            if(lotteryBtn.isAnimating){
                lotteryBtn.cancelAnimation()
                countDownTimer.cancel()
            } else {
                lotteryBtn.playAnimation()
                countDownTimer.start()
            }
        }
    }
}