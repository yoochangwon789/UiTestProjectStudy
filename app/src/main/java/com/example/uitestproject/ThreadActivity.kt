package com.example.uitestproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_thread.*

class ThreadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread)

        // Thread 을 생성해 Runnable 에게 담아주고
        // Runnable 을 Thread 에 넣어준다

        val runnable: Runnable = object : Runnable {
            override fun run() {
                Log.d("thread-1", "Tread1 id made")
            }
        }

        val thread: Thread = Thread(runnable)

        button.setOnClickListener {
            thread.start()
        }

        // 람다를 사용하지 않은 익명함수
        Thread(object : Runnable {
            override fun run() {
                Log.d("thread-1", "Tread2 id made")
            }
        }).start()

        // 람다사용
        Thread(Runnable {
            Thread.sleep(2000)
            Log.d("thread-1", "Tread3 id made")

            // UI 는 MainThread 에서만 관리가 가능하므로 runOnUiThread 를 명시해줘야함
            // 그렇지 않은 경우 크래쉬가 남
            runOnUiThread {
                button.setBackgroundColor(getColor(R.color.black))
            }

        }).start()
    }
}