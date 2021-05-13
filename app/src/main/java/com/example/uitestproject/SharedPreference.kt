package com.example.uitestproject

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_shared_preference.*

class SharedPreference : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preference)

        // SharedPreference
        // getSharedPreferences(name -> 여러개를 만들수 있기 때문에 구분 때문에 이름 설정, mode)
        // Mode
        // - MODE_PRIVATE : 생성한 application 에서만 사용 가능
        // - MODE_WORLD_READABLE : 다른 application 사용 가능 -> 읽을수만 있다
        // - MODE_WORLD_WRITEABLE : 다른 application 사용 가능 -> 기록도 가능
        // - MODE_MULTI_PROCESS : 이미 호출되어 사용중인지 체크
        // - MODE_APPEND : 기존 preference 에 신규로 추가
        // SharedPreference 에 저장하는 방법
        val sharedPreference = getSharedPreferences("sp1", MODE_PRIVATE)

        // sharedPreference 데이터를 넣으려면 데이터를 넣어줄 수 있는 editor 가 필요
        // sharedPreference 를 editor 로 가져와서 데이터를 넣어줘야 한다
        val editor: SharedPreferences.Editor = sharedPreference.edit()
        editor.putString("hello", "안녕하세요")
        editor.commit()

        // sp1 -> SharedPreference
        //        (Key,Value) -> ("Hello", "안녕하세요")
        // sp2 -> SharedPreference
        //        (Key,Value) -> ("Hello", "안녕하세요11")

        button_sp1.setOnClickListener {
            // SharedPreference 에 값을 불러오는 방법
            val sharedPreference = getSharedPreferences("sp1", MODE_PRIVATE)
            val value = sharedPreference.getString("hello", "데이터 없음")
            Log.d("key-value", "Value : " + value)
        }
    }
}