package com.example.uitestproject

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import java.lang.Exception

class AsyncActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async)
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
