package com.example.uitestproject

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_intent2.*

class Intent2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent2)

        result.setOnClickListener{
            // 인텐트의 정보를 받기위한 putIntExtra
            var number1 = intent.getIntExtra("number1", 0)
            var number2 = intent.getIntExtra("number2", 0)

            Log.d("number", ""+number1)
            Log.d("number", ""+number2)

            val result = number1 + number2

            // 결과 값은 Intent 에 넣어준다
            val resultIntent = Intent()
            resultIntent.putExtra("result", result)

            // 결과를 보내준다
            setResult(Activity.RESULT_OK, resultIntent)
            finish() // -> Activity 종료
        }
    }
}