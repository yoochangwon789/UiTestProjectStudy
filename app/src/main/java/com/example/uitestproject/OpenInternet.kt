package com.example.uitestproject

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import kotlinx.android.synthetic.main.activity_open_internet.*

class OpenInternet : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_open_internet)

        open.setOnClickListener {
            val address = address_edit_text.text.toString()

            val intentInternet = Intent(Intent.ACTION_VIEW, Uri.parse(address))
            startActivity(intentInternet)
        }

        address_edit_text.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                if (p0.toString() == "abc") {
                    //Log.d("edit", "text id abc")
                }
                //Log.d("edit", "afterTextChanged : " + p0)
            }

            override fun beforeTextChanged(p0: CharSequence?, start: Int, count: Int, after: Int) {
                Log.d("edit", "beforeTextChanged : " + p0)
                Log.d("edit", "beforeTextChanged start : " + start)
                Log.d("edit", "beforeTextChanged count : " + count)
                Log.d("edit", "beforeTextChanged after : " + after)

            }

            override fun onTextChanged(p0: CharSequence?, start: Int, count: Int, after: Int) {
                Log.d("edit", "onTextChanged : " + p0)
                Log.d("edit", "onTextChanged start : " + start)
                Log.d("edit", "onTextChanged count : " + count)
                Log.d("edit", "onTextChanged after : " + after)
            }
        })
    }
}