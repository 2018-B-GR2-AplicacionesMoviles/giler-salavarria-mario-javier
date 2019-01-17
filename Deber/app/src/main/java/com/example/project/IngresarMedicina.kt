package com.example.project

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_ingresar_medicina.*

class IngresarMedicina : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingresar_medicina)
        btnAceptarMedicina.setOnClickListener { aceptarIngreso() }
        btnCancelarMedicina.setOnClickListener { cancelarIngreso() }
    }
    fun cancelarIngreso(){
        val intentCancelar= Intent(this, MainActivity::class.java)
        startActivity(intentCancelar)
    }

    fun aceptarIngreso(){
        val medicina= Medicina(nombreMed = txtNombreMedicina.text.toString(),
            codigoMed = txtCodigoMedicina.text.toString(),
            precioMed = txtPrecioMedicina.text.toString(),
            observacionMed = txtObservacionMedicina.text.toString(),
            dosisMed = txtDosisMedicina.text.toString())
        val retorno = Intent(this, MainActivity::class.java)
        startActivity(retorno)
        var helper = SQLite(this)
        helper.crearMedicina(medicina)
        Log.i("BDD","Medicina creada")

    }
}
