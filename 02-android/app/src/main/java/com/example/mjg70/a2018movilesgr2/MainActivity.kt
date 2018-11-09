package com.example.mjg70.a2018movilesgr2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        boton_navegar.setOnClickListener{
           /* Log.i("navegacion", "Hola")
            Log.w("navegacion", "Hola")
            Log.d("navegacion", "Hola")
            Log.e("navegacion", "Hola")
            Log.v("navegacion", "Hola")*/
            irPantallaBotones()
        }
    }

    fun irPantallaBotones(){
        val intentIrBotones=Intent(this, ButtonActivity::class.java)
        intentIrBotones.putExtra("nombre", "Mario")
        intentIrBotones.putExtra("apellido", "Giler")
        startActivity(intentIrBotones)
    }
}
