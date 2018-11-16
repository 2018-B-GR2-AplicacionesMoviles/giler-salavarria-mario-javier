package com.example.mjg70.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_encuesta.*

class EncuestaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_encuesta)
        btnRegistrar.setOnClickListener { registrarMedicina() }
    }

    fun registrarMedicina(){
        Toast.makeText(this@EncuestaActivity, "Medicina registrada exitósamente", Toast.LENGTH_SHORT).show()

    }
}
