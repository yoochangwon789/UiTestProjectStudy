package com.example.uitestproject

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_intent.*

class Intent1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)


        change_activity.setOnClickListener {
            val intent = Intent(this@Intent1, Intent2::class.java)

//            // 인텐트의 정보를 보내기위한 putExtra(첫 번째 인자는 이름을 지은다, 보낼 값)
//            // key, Value 방식 -> Key 와 Value 를 쌍으로 만들어 저장한다.
//            intent.putExtra("number1", 1)
//            intent.putExtra("number2", 2)
//            startActivity(intent)

//            // 위의 코드와 같다
//            val intent2 = Intent(this@Intent1, Intent2::class.java)
//            // apply -> 블럭안에 내포시킬 수 있다 코드의 간결성과 가독성을 위한 코드
//            intent2.apply {
//                this.putExtra("number1", 1)
//                this.putExtra("number2", 2)
//            }
//            // 전달만 하는 요청
//            //startActivity(intent2)
//
//            // 리턴을 받는 요청
//            // requestCode 는 보낼때의 이름
//            startActivityForResult(intent2, 200)

            // 암시적 인텐트
            val intent3 = Intent(Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com")))
            startActivity(intent3)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 200) {
            Log.d("number", "" + requestCode)
            Log.d("number", "" + resultCode)

            val result = data?.getIntExtra("result", 0)
            Log.d("number", "" + result)
        }

    }
}