package com.example.project

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_ingresar.*

class IngresarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingresar)
        btnAceptar.setOnClickListener { aceptarIngreso() }
        btnConsultar.setOnClickListener{ consultar()}
    }
    fun aceptarIngreso(){

        val medicina= Medicina(nombreMed = txtNombreMed.text.toString(),
            codigoMed = txtCodigoMed.text.toString(),
            precioMed = txtPrecio.text.toString(),
            observacionMed = txtObservacionMed.text.toString(),
            dosisMed = txtDosisMed.text.toString())
        var helper = SQLite(this)
        helper.crearUsuarioFormulario(medicina)
        Log.i("BDD","medicina creada")


    }

    fun consultar(){
        val intent = Intent(this, ConsultarActivity::class.java)
        startActivity(intent)
    }
}
