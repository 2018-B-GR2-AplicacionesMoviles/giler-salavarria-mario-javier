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
        btnFarmacia.setOnClickListener { aceptarIngreso() }
        btnConsultar.setOnClickListener{ consultar()}
        btnCancelarTip.setOnClickListener { borrar() }
    }
    fun aceptarIngreso(){

        val farmacia= Farmacia(nombreFar = txtNombreMedicina.text.toString(),
            direccionFar = txtCodigoMedicina.text.toString())
        var helper = SQLite(this)
        helper.crearFarmacia(farmacia)
        txtNombreMedicina.setText("")
        txtCodigoMedicina.setText("")
        Log.i("BDD","Farmacia creada")

    }

    fun consultar(){
        val intent = Intent(this, ConsultarActivity::class.java)
        startActivity(intent)

    }
    fun borrar(){
        txtNombreMedicina.setText("")
        txtCodigoMedicina.setText("")
    }
}
