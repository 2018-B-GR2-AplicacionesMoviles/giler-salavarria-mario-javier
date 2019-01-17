package com.example.project

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_consultar.*

class ConsultarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consultar)
        var helper = SQLite(this)
        var lstFarmacia=helper.cargarFarmacias()
        Log.i("BDD","farmacia cargada")
        val layoutManager = LinearLayoutManager(this)
        val rv = recycler_view
        val adaptador = MedicinaAdaptador(lstFarmacia, this, rv)
        recycler_view.layoutManager = layoutManager
        recycler_view.itemAnimator = DefaultItemAnimator()
        recycler_view.adapter = adaptador
        adaptador.notifyDataSetChanged()
    }
    fun mandarActual(farmacia:Farmacia){
        val intentFarmaciaSeleccionada = Intent(this, IngresarActivity::class.java)
        intentFarmaciaSeleccionada.putExtra("Farmacia", farmacia)
        startActivity(intentFarmaciaSeleccionada)
    }
}
class MedicinaAdaptador(private val listaFarmacia: List<Farmacia>,
                        private val contexto: ConsultarActivity,
                        private val recyclerView: RecyclerView) :
    RecyclerView.Adapter<MedicinaAdaptador.MyViewHolder>() {


    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var nombreTextView: TextView
        var cedulaTextView: TextView

        init {
            nombreTextView = view.findViewById(R.id.text_view_nombre) as TextView
            cedulaTextView = view.findViewById(R.id.text_view_cedula) as TextView


            // val left = apellido.paddingLeft
            // val top = apellido.paddingTop
            // Log.i("vista-principal", "Hacia la izquierda es $left y hacia arriba es $top")

            val layout = view.findViewById(R.id.relative_layout) as RelativeLayout

            layout
                .setOnClickListener {
                    val nombreActual = it.findViewById(R.id.text_view_nombre) as TextView
                    val direeccionActual = it.findViewById(R.id.text_view_cedula) as TextView
                    val farmaciaActual = Farmacia(nombreFar = nombreActual.toString(), direccionFar = direeccionActual.toString())


                    Log.i("recycler-view",
                        "El nombre actual es: ${nombreActual.text}")

                }

            val boton = view.findViewById(R.id.button_ver_info) as Button

            /*boton
                .setOnClickListener {
                    val toast = Toast.makeText(
                        it.context,
                        "Hola ${nombreTextView.text}",
                        Toast.LENGTH_LONG
                    )
                    toast.show()

                    BDD.crearMas()
                    val layoutManager = LinearLayoutManager(contexto)
                    val adaptador = MedicinaAdaptador(BDD.usuarios, contexto, recyclerView)

                    recyclerView.layoutManager = layoutManager
                    recyclerView.itemAnimator = DefaultItemAnimator()
                    recyclerView.adapter = adaptador

                    adaptador.notifyDataSetChanged()
                }*/


            /*
            layout
                    .setOnClickListener({ v ->
                        val nombreActual = v.findViewById(R.id.text_view_nombre) as TextView

                        Log.i("recycler-view",
                                "El nombre actual es: ${nombreActual.text}")
                        // nombreActual.text = "Otro texto"

                    })
            */
            /*
                cedula.setOnClickListener { v ->
                    val cedulaActual = v.findViewById(R.id.txtv_cedula) as TextView
                    val toast = Toast.makeText(v.context, "Hola ${cedulaActual.text}", Toast.LENGTH_LONG)
                    toast.show()
                    val intent = Intent(v.context, ActividadLayouts::class.java)
                    startActivity(v.context, intent, null)
                }
                */
        }
    }

    // Definimos el layout
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int): MyViewHolder {

        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.list_layout,
                parent,
                false
            )

        return MyViewHolder(itemView)
    }

    // Llenamos los datos del layout
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val farmacia = listaFarmacia[position]

        holder.nombreTextView.setText(farmacia.nombreFar)
        holder.cedulaTextView.setText(farmacia.direccionFar)
    }

    override fun getItemCount(): Int {
        return listaFarmacia.size
    }

}

