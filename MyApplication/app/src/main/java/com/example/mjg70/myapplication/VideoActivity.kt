package com.example.mjg70.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_video.*

class VideoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)
        mostrarVideo()
    }

    fun mostrarVideo() {

        videoView.setVideoPath(
            "http://www.ebookfrenzy.com/android_book/movie.mp4")
        videoView.start()
    }
}
