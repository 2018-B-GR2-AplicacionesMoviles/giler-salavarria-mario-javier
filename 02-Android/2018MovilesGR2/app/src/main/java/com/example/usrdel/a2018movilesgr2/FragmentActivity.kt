package com.example.usrdel.a2018movilesgr2

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import kotlinx.android.synthetic.main.activity_fragment.*
import java.security.AccessControlContext

class FragmentActivity : AppCompatActivity() {


    lateinit var fragmentoActual: Fragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        fragmentoActual = BlankFragment()
    btn_cambiar.setOnClickListener{
        cambiarTexto()
    }

    }

    fun cambiarTexto(){
        val fragmentManager = supportFragmentManager

        val fragmentTransaction = fragmentManager.beginTransaction()

        val primerFragmento = BlankFragment()

        //Empezar la transaccion
        val argumentos = Bundle()
        argumentos.putString("nombre", "Mario Giler")
        argumentos.putInt("edad", 23)
        primerFragmento.arguments = argumentos

        fragmentTransaction.remove(fragmentoActual)
        fragmentTransaction.replace(R.id.fragment_primer, primerFragmento)
        fragmentoActual=primerFragmento
        fragmentTransaction.commit()

    }


}

