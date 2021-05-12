package com.example.uitestproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Context : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_context)

        // Context 는 가장 위에있는 부모 클래스 이며 왠만한 것들은 상속하고 있어서
        // this 를 사용하자
        val context: Context = this
        val applicationContext: Context = applicationContext as Context

    }
}