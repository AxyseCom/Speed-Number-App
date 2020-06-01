package com.example.speednumber.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.speednumber.R
import com.example.speednumber.RandomGenerator
import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : AppCompatActivity() {
    
    var answerId = (0..3).random()

    val num: RandomGenerator = RandomGenerator(1, 99)
    var score: Int = -1



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        buttonScore.isClickable = false

        getTask()

        object:CountDownTimer(60000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                    gameTimer.setText(("" + millisUntilFinished / 1000))

                topLeftAnswer.setOnClickListener{
                    if(answerId == 0){
                        getTask()
                    }else onFinish()
                }
                topRightAnswer.setOnClickListener {
                    if(answerId == 1){
                        getTask()
                    }else onFinish()
                }
                bottomLeftAnswer.setOnClickListener {
                    if(answerId == 2){
                        getTask()
                    }else onFinish()
                }
                bottomRightAnswer.setOnClickListener {
                    if(answerId == 3){
                        getTask()
                    }else onFinish()
                }

            }
            override fun onFinish() {
                cancel()
                gameTimer.setText("GAME OVER")
                topLeftAnswer.isClickable = false
                topRightAnswer.isClickable = false
                bottomRightAnswer.isClickable = false
                bottomLeftAnswer.isClickable = false
            }
        }.start()
    }

    @SuppressLint("SetTextI18n")
    fun getTask(){

        score++
        buttonScore.setText("" + score)

        var symbolId = (0..1).random()
        var leftNumber: Int = num.getLeftNumber()
        var rightNumber: Int = num.getRightNumber()

        var randomNumber1: Int = num.getFalseNumber()
        var randomNumber2: Int = num.getFalseNumber()
        var randomNumber3: Int = num.getFalseNumber()

        var falseNum1: Int
        var falseNum2: Int
        var falseNum3:Int

        var trueNumber: Int
        when(symbolId){
            0 -> {
                trueNumber = leftNumber + rightNumber
                falseNum1 = randomNumber1 + randomNumber2
                falseNum2 = randomNumber2 + randomNumber3
                falseNum3 = randomNumber1 + randomNumber3
                operation.setText("+" )
            }
            1 -> {
                trueNumber = leftNumber * rightNumber
                falseNum1 = randomNumber1 * randomNumber2
                falseNum2 = randomNumber2 * randomNumber3
                falseNum3 = randomNumber1 * randomNumber3
                operation.setText("*")
            }
            else -> {
                trueNumber = leftNumber + rightNumber
                falseNum1 = randomNumber1 + randomNumber2
                falseNum2 = randomNumber2 + randomNumber3
                falseNum3 = randomNumber1 + randomNumber3
            }
        }

        when(answerId){
            0 -> {
                topRightAnswer.setText("" + falseNum1)
                topLeftAnswer.setText("" + trueNumber)
                bottomLeftAnswer.setText("" + falseNum2)
                bottomRightAnswer.setText("" + falseNum3)
            }
            1 ->{
                topRightAnswer.setText("" + trueNumber)
                topLeftAnswer.setText("" + falseNum1)
                bottomLeftAnswer.setText("" + falseNum2)
                bottomRightAnswer.setText("" + falseNum3)
            }
            2 ->{
                topRightAnswer.setText("" + falseNum1)
                topLeftAnswer.setText("" + falseNum2)
                bottomLeftAnswer.setText("" + trueNumber)
                bottomRightAnswer.setText("" + falseNum3)
            }
            3 ->{
                topRightAnswer.setText("" + falseNum1)
                topLeftAnswer.setText("" + falseNum2)
                bottomLeftAnswer.setText("" + falseNum3)
                bottomRightAnswer.setText("" + trueNumber)
            }

        }

        leftNum.setText("" + leftNumber)
        rightNum.setText("" + rightNumber)



    }

}