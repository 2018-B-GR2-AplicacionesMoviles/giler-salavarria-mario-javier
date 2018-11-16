package com.example.mjg70.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        btnNavegador.setOnClickListener { enviarNavegar() }
        btnCalendario.setOnClickListener { enviarCalendario() }
        btnVideo.setOnClickListener { enviarVideo() }
        btnMapa.setOnClickListener { enviarMapa() }
    }

    fun enviarNavegar(){
        val enviarNavegar = Intent(this, Menu2Activity::class.java)
        startActivity(enviarNavegar)
    }
    fun enviarVideo(){
        val enviarVideo= Intent(this, VideoActivity::class.java)
        startActivity(enviarVideo)
    }
    fun enviarCalendario(){
        val enviarCalendario = Intent(this, CalendarActivity::class.java)
        startActivity(enviarCalendario)
    }
    fun enviarMapa(){
        val enviarMapa= Intent(this,MapsActivity::class.java)
        startActivity(enviarMapa)
    }
}
