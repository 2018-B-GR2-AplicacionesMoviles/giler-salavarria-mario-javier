package com.example.project

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnFarmacia.setOnClickListener{ingresarFarmacia()}
        btnTipoMedicina.setOnClickListener { ingresarTipoMedicina() }
        btnMedicina.setOnClickListener {ingresarMedicina()}

    }

    fun ingresarFarmacia(){
        val intent = Intent(this, IngresarActivity::class.java)
        startActivity(intent)
    }
    fun ingresarTipoMedicina(){
        val intent = Intent(this, IngresarTipoMed::class.java)
        startActivity(intent)
    }
    fun ingresarMedicina(){
        val intent = Intent(this, IngresarMedicina::class.java)
        startActivity(intent)
    }
}
