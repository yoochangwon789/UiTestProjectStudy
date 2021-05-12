package com.example.uitestproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_phone_book_detail.*

class PhoneBookDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_book_detail)

//        val resultName = intent.getStringExtra("name")
//        val resultNumber = intent.getStringExtra("number")
//
//        val resultNameView = findViewById<TextView>(R.id.person_detail_name)
//        val resultNumberView = findViewById<TextView>(R.id.person_detail_number)
//
//        resultNameView.setText(resultName)
//        resultNumberView.setText(resultNumber)

//        back.setOnClickListener {
//            val result = Intent()
    //           finish()
 //       }

        getPersonInfoAndDraw()

        back.setOnClickListener {
            // 뒤로가기 기능 메서드드
            onBackPressed()
        }
    }

    private fun getPersonInfoAndDraw() {
        val resultName = intent.getStringExtra("name")
        val resultNumber = intent.getStringExtra("number")

        person_detail_name.setText(resultName)
        person_detail_number.setText(resultNumber)
    }
}