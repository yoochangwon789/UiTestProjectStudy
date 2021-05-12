package com.example.uitestproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.activity_fragment.*

class FragmentActivity : AppCompatActivity(), FragmentOne.OnDataPassListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        Log.d("life_cycle", "onCreate")

        val fragmentOne : FragmentOne = FragmentOne()

        // 프라그먼트의 데이터를 넣는 방법
        val bundle: Bundle = Bundle()
        bundle.putString("hello", "hello")
        fragmentOne.arguments = bundle

        button.setOnClickListener {
            // 프라그먼트를 동적으로 작동하는 방법 -> 동작을 하기 위해서는 FragmentManager 의 도움을 받아야 함
            // 프라그먼트 replace/add
            val fragmentManager : FragmentManager = supportFragmentManager

            // Transaction
            // 작업의 단위 -> 시작과 끝이 있다

            // 시작 하겠다
            val fragmentTransaction = fragmentManager.beginTransaction()

            // 사용할 컨테이너 id를 적어주고 프라그먼트를 바꿔준다
            fragmentTransaction.replace(R.id.container, fragmentOne)

            // 끝을 내면 replace 된다
            fragmentTransaction.commit()

            // 끝을 내는 방법
            // commit -> 시간 될 때 해 (좀더 안정적)
            // commitNow -> 지금 당장해
        }

        button2.setOnClickListener {
            // 프라그먼트 remove/detach 하는 방법 -> remove 는 다시 지우고 다시 불러오기 가능, detach 는 불가능
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.remove(fragmentOne)
            fragmentTransaction.commit()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("life_cycle", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("life_cycle", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("life_cycle", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("life_cycle", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("life_cycle", "onDestroy")
    }

    override fun onDataPass(data: String?) {
        Log.d("pass", ""+data)
    }
}