package com.example.mjg70.examen

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_actualizar.*


class ActualizarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actualizar)
        val medicinaRecibida = intent.getParcelableExtra<Medicina>("Medicina")
        txtNombreMed.setText(medicinaRecibida.nombreMed.toString())
        txtCodigoMed.setText(medicinaRecibida.codigoMed.toString())
        txtPrecio.setText(medicinaRecibida.precioMed.toString())
        txtObservacionMed.setText(medicinaRecibida.observacionMed.toString())
        txtDosisMed.setText(medicinaRecibida.dosisMed.toString())
        btnBorrar.setOnClickListener { borrar() }
        btnActualizar.setOnClickListener { actualizar() }
    }
    fun borrar(){
        BDMedicina.eliminarMedicina(txtNombreMed.text.toString())
        val intentMenu = Intent(this, MainActivity::class.java)
        startActivity(intentMenu)
    }
    fun actualizar(){

        val nombreMed= txtNombreMed.text.toString()
        val codigoMed= txtCodigoMed.text.toString()
        val precioMed= txtPrecio.text.toString()
        val observacionMed= txtObservacionMed.text.toString()
        val dosisMed= txtDosisMed.text.toString()

        val medicina= Medicina(nombreMed = nombreMed,
            codigoMed = codigoMed,
            precioMed = precioMed,
            observacionMed = observacionMed,
            dosisMed = dosisMed)
        BDMedicina.actualizarMedicina(medicina)
        val intentMenu = Intent(this, MainActivity::class.java)
        startActivity(intentMenu)
    }
}
