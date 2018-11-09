package com.example.mjg70.a2018movilesgr2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_button.*

class ButtonActivity : AppCompatActivity() {
    var nombre:String=""
    var apellido:String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_button)
        capturarDatosIntent()
        btn_enviar_correo.setOnClickListener { enviarItemMail() }
        txt_content.text="${nombre} ${apellido}"
    }

    fun capturarDatosIntent(){
        nombre=intent.getStringExtra("nombre")
        apellido=intent.getStringExtra("apellido")
    }

    fun enviarItemMail(){
        val correo = txt_mail.text
        val subject = txt_mail.text
        val contenido = txt_mail.text
        val intent=Intent(Intent.ACTION_SEND)
        intent.type="text/html"
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(correo, "mariojavier0795@gmai.com"))
        intent.putExtra(Intent.EXTRA_EMAIL, subject)
        intent.putExtra(Intent.EXTRA_EMAIL, contenido)
        startActivity(intent)
    }
}
