package com.example.project

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class SQLite (context:Context?):
    SQLiteOpenHelper(context, "moviles", null, 1) {
    override fun onCreate(baseDeDatos: SQLiteDatabase?) {
        val sqlTable = "CREATE TABLE Medicina( id_medicina integer primary key autoincrement," +
                "nombre_medicina varchar(500)," +
                "codigo_medicina varchar(500),"+
                "precio_medicina varchar(500),"+
                "observacion_medicina varchar(500)," +
                "dosis_medicina varchar(500))"
        Log.i("DB", "Creando Tabla")
        baseDeDatos?.execSQL(sqlTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun existeUsuarioFormulario(nombre_medicina:String?): Medicina {
        val statement = "select * from Medicina where nombre_medicina="+nombre_medicina
        val dbReadable = readableDatabase
        val resultado = dbReadable.rawQuery(statement, null)
        val respuestaUsuario = Medicina(null,null, null, null, null)
        if (resultado.moveToFirst()) {

            do {
                respuestaUsuario.nombreMed=resultado.getString(1)
                respuestaUsuario.codigoMed = resultado.getString(2)
                respuestaUsuario.precioMed = resultado.getString(3)
                respuestaUsuario.observacionMed = resultado.getString(4)
                respuestaUsuario.dosisMed = resultado.getString(5)
            } while (resultado.moveToNext())
        }
        resultado.close()
        dbReadable.close()
        return respuestaUsuario

    }

    fun cargarMedicinas():ArrayList<Medicina>{
        val statement = "select * from Medicina"
        val lstMedicina = ArrayList<Medicina>()
        val dbReadable = readableDatabase
        val resultado = dbReadable.rawQuery(statement, null)
        if (resultado.moveToFirst()) {

            do {
                val respuestaUsuario = Medicina(null,null, null, null, null)
                respuestaUsuario.nombreMed=resultado.getString(1)
                respuestaUsuario.codigoMed = resultado.getString(2)
                respuestaUsuario.precioMed = resultado.getString(3)
                respuestaUsuario.observacionMed = resultado.getString(4)
                respuestaUsuario.dosisMed = resultado.getString(5)
                lstMedicina.add(respuestaUsuario)
            } while (resultado.moveToNext())
        }
        resultado.close()
        dbReadable.close()
        return lstMedicina

    }



    fun crearUsuarioFormulario(medicina:Medicina): Boolean {

        // Base de datos de escritura
        val dbWriteable = writableDatabase
        val cv = ContentValues()
        // Valores de los campos
        cv.put("nombre_medicina", medicina.nombreMed)
        cv.put("codigo_medicina", medicina.codigoMed)
        cv.put("precio_medicina",medicina.precioMed)
        cv.put("observacion_medicina",medicina.observacionMed)
        cv.put("dosis_medicina",medicina.dosisMed)
        val resultado: Long = dbWriteable
            .insert(
                "Medicina", // Nombre de la tabla
                null,
                cv)
        dbWriteable.close()
        return if (resultado.toInt() == -1) false else true
    }



    fun eliminarUsuarioFormulario(medicina: Medicina): Boolean {

        val dbWriteable = writableDatabase
        val nombreTabla = "Medicina"

        val clausulaWhere = "nombre_medicina = ?"

        val parametros = arrayOf(medicina.nombreMed)

        val respuesta = dbWriteable.delete(
            nombreTabla,
            clausulaWhere,
            parametros
        )

        return if (respuesta == -1) false else true

    }

    fun actualizarUsuarioFormulario(medicina:Medicina): Boolean {
        // Base de datos de escritura
        val dbWriteable = writableDatabase
        val cv = ContentValues()
        // Valores de los campos
        cv.put("nombre_medicina", medicina.nombreMed)
        cv.put("codigo_medicina", medicina.codigoMed)
        cv.put("precio_medicina",medicina.precioMed)
        cv.put("observacion_medicina",medicina.observacionMed)
        cv.put("dosis_medicina",medicina.dosisMed)
        val resultado = dbWriteable
            .update(
                "Medicina", // Nombre de la tabla
                cv, // Valores a actualizarse
                "nombre_medicina=?", // Where
                arrayOf(medicina.nombreMed) // Parametros
            )
        dbWriteable.close()
        return if (resultado.toInt() == -1) false else true
    }


}
