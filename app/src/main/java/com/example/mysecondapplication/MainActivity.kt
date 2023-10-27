package com.example.mysecondapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.secondexercise.HundreedMap
import com.example.secondexercise.getDozen
import com.example.secondexercise.mainMap
import com.example.secondexercise.wholeHundreedMap

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.button).setOnClickListener {
            val number = findViewById<EditText>(R.id.textView2).text.toString()
            showNumber(number.toInt())
        }
    }
    fun showNumber(number: Int){
//        var result = ""
        if (number in 1..1000) {
            val numberString = number.toString()
            val   result = when (numberString.length) {
                1 -> mainMap[number]!!
                2 -> {
                    getDozen(number)

                }

                3 -> {
                    wholeHundreedMap[number] ?: (HundreedMap[number / 100]!! + getDozen(number % 100))
                }

                else -> {
                    "ათასი"
                }
            }
            findViewById<TextView>(R.id.textView).text = result
        }
        else{
            findViewById<TextView>(R.id.textView).text = "გთხოვთ შეიყვანოთ ვალიდური რიცხვი"
        }

    }

}