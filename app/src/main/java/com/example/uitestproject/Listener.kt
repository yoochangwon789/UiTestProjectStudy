package com.example.uitestproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_listener.*

class Listener : AppCompatActivity() {
    var number = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listener)

        // xml 뷰를 가져오는 2가지 방법

        // 1 번째
        // textView 의 hello 의 아이디를 가지는 것을 불러오는 것
        // val textView: TextView = findViewById(R.id.hello)

        // 2 번째 -> XML import 해서 가져온다
        // 절달되는 방법은 안드로이드 OS 가 해주고 안드로이드 시스템에서 사용자가 클릭하면
        // 뷰의 달려 있는 리스너를 쫙 찾고 그 리스너에게 알려준다 그러면 정의한 리스너의 내용이 호출된다

        //  1 -> 람다 사용방식(익명함수를 간단하게 쓰는 방식)
        hello.setOnClickListener {
            Log.d("click", "Click!!")
        }

        // 2 -> 람다를 사용하지 않은 방식(익명함수방식)
        hello.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                Log.d("click", "Click!!")
            }
        })

        // 3 -> 이름이 필요한 경우(click)
        val click = object : View.OnClickListener {
            override fun onClick(p0: View?) {
                Log.d("click", "Click!!")
                // TextView 를 변경하는 방식
                hello.setText("안녕하세요")
                // 이미지를 변경하는 방식
                image.setImageResource(R.drawable.dog_9)
                number += 10
                Log.d("number", number.toString())
            }
        }
        hello.setOnClickListener(click)

        // 뷰를 조작 하는 함수들
        // 1 -> setText
        // 2 -> setImageResource


    }
}