package com.example.uitestproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_library_glide.*

class LibraryActivityGlide : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library_glide)

        Glide.with(this)
            .load("https://dimg.donga.com/wps/NEWS/IMAGE/2021/01/17/104953245.2.jpg")
            .centerCrop()
            .into(glide)
    }
}