package com.example.mjg70.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSesion.setOnClickListener{
            /* Log.i("navegacion", "Hola")
             Log.w("navegacion", "Hola")
             Log.d("navegacion", "Hola")
             Log.e("navegacion", "Hola")
             Log.v("navegacion", "Hola")*/
            irPantallaBotones()
        }
    }
    fun irPantallaBotones(){
        val iniciarSesion = Intent(this, MenuActivity::class.java)
        startActivity(iniciarSesion)
    }

}


