package com.example.project

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_ingresar.*
import kotlinx.android.synthetic.main.activity_ingresar_tipo_med.*

class IngresarTipoMed : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingresar_tipo_med)
        btnAceptarTip.setOnClickListener { ingresarTipoMedicia() }

    }
    fun ingresarTipoMedicia(){
        val tipoMedicina= TipoMedicina(nombreTipMed= txtTipoMed.text.toString())
        var helper = SQLite(this)
        helper.crearTipoMedicina(tipoMedicina)
        txtNombreMedicina.setText("")
        txtCodigoMedicina.setText("")
        Log.i("BDD","Tipo medicina creada")
    }
    /*fun consultar(){
        val intent = Intent(this, ConsultarActivity::class.java)
        startActivity(intent)

    }*/
    fun borrar(){
        txtTipoMed.setText("")

    }

}
