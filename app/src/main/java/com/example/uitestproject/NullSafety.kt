package com.example.uitestproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class NullSafety : AppCompatActivity() {

    lateinit var lateCar: Car

    class Car(var number: Int) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_null_safety)

//        val number: Int = 10
//        val number1: Int? = null
//
//        // !! -> 개발자가 null 이 아님을 보장
//        val number5: Int = number1!! + 10
//
//
//        // number1 가 null 값이 아니라면 ? 이하를 실행시켜라 만약 Null 이면 ? 앞에 있는 값이 들어감
//        // 즉  number1 의 값이 number3 에 들어가고 number3 는 null 이다
//        val number3 = number1?.plus(number)
////        Log.d("number", "number3 : " + number3)
//
//        // 삼항 연산자 -> 엘비스 연산자(?:)
//        // number1 이 null 이 아니면 number1 이 들어감
//        // number1 이 null 이면 10이 들어감
//        val number4 = number1 ?: 10
////        Log.d("number", "number4 : " + number4)
//
//        lateCar = Car(10)
//        Log.d("number", "late Number : " + lateCar.number)
    }

    fun plus(a: Int, b: Int?): Int {
        if (b != null) return a + b
        else return a
    }

    fun plus2(a: Int, b: Int?): Int? {
        return b?.plus(a)
    }
}