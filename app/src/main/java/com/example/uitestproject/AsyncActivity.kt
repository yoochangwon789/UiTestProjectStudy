package com.example.uitestproject

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_async.*
import java.lang.Exception

class AsyncActivity : AppCompatActivity() {

    var task: BackgroundAsyncTest? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async)

        start.setOnClickListener {
            task = BackgroundAsyncTest(progress_bar, ment)
            task?.execute()
        }

        stop.setOnClickListener {
            //task?.cancel(true)
            startActivity(Intent(this, Intent2::class.java))
        }
    }

    // Async 는 Activity 가 종료되도 멈추지 않기 때문에 라이프 싸이클을 이용해 정지시켜줘야 함
    override fun onPause() {
        task?.cancel(true)
        super.onPause()
    }
}

class BackgroundAsyncTest(
    val progressBar: ProgressBar,
    val progressText: TextView
): AsyncTask<Int, Int, Int>() {
    // result -> onPostExecute
    // progress -> onProgressUpdate 에서 사용할 타입
    // params -> doIntBackground 에서 사용할 타입

    var percent: Int = 0

    override fun onPreExecute() {
        percent = 0
        progressBar.setProgress(percent)
    }

    // vararg -> int 가 여러개 올 수 있다
    override fun doInBackground(vararg params: Int?): Int {
        // 완료가 되어 있지 않다면 반복 즉 취도되지 않았다면
        while (isCancelled() == false) {
            percent++
            Log.d("percent", "persent : " + percent)
            if (percent > 100) break
            // main Thread 로 보내 주는 역할
            else publishProgress(percent)
        }
        try {
            Thread.sleep(100)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return percent
    }

    override fun onProgressUpdate(vararg values: Int?) {
        progressBar.setProgress(values[0] ?: 0)
        progressText.setText("퍼센트 : " + values[0])
        super.onProgressUpdate(*values)
    }

    override fun onPostExecute(result: Int?) {
        progressText.setText("작업이 완료되었습니다.")
    }

    // 우리가 인위적으로 만든 취소 버튼을 위한 작업 취소 되면 이게 호출
    override fun onCancelled() {
        progressBar.setProgress(0)
        progressText.setText("작업이 취소 되었습니다.")
    }
}
