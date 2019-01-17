package com.example.project

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class SQLite (context:Context?):
    SQLiteOpenHelper(context, "moviles", null, 1) {
    override fun onCreate(baseDeDatos: SQLiteDatabase?) {
        val sqlTable = "CREATE TABLE Farmacia( id_farmacia integer primary key autoincrement," +
                "nombre_farmacia varchar(500)," +
                "direccion_farmacia varchar(500));"+
                "CREATE TABLE TipoMedicina( id_tipo_med integer primary key autoincrement," +
                "nombre_tipo_med varchar(500),"+
                "id_farmacia integer," +
                "foreign key(id_farmacia) references Farmacia(id_farmacia));"+
                "CREATE TABLE Medicina( id_medicina integer primary key autoincrement," +
                "nombre_medicina varchar(500)," +
                "codigo_medicina varchar(500),"+
                "precio_medicina varchar(500),"+
                "observacion_medicina varchar(500)," +
                "dosis_medicina varchar(500),"+
                "id_tipo_med integer," +
                "foreign key(id_tipo_med) references TipoMedicina(id_tipo_med));"
        Log.i("DB", "Esquema Creado")
        baseDeDatos?.execSQL(sqlTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun cargarFarmacias():ArrayList<Farmacia>{
        val statement = "select * from Farmacia"
        val lstFarmacia = ArrayList<Farmacia>()
        val dbReadable = readableDatabase
        val resultado = dbReadable.rawQuery(statement, null)
        if (resultado.moveToFirst()) {

            do {
                val respuestaFarmacia = Farmacia(null,null)
                respuestaFarmacia.nombreFar=resultado.getString(1)
                respuestaFarmacia.direccionFar = resultado.getString(2)
                lstFarmacia.add(respuestaFarmacia)
            } while (resultado.moveToNext())
        }
        resultado.close()
        dbReadable.close()
        return lstFarmacia

    }



    fun crearFarmacia(farmacia:Farmacia): Boolean {

        // Base de datos de escritura
        val dbWriteable = writableDatabase
        val cv = ContentValues()
        // Valores de los campos
        cv.put("nombre_farmacia", farmacia.nombreFar)
        cv.put("direccion_farmacia", farmacia.direccionFar)
        val resultado: Long = dbWriteable
            .insert(
                "Farmacia", // Nombre de la tabla
                null,
                cv)
        dbWriteable.close()
        return if (resultado.toInt() == -1) false else true
    }



    fun eliminarFarmacia(farmacia: Farmacia): Boolean {

        val dbWriteable = writableDatabase
        val nombreTabla = "Farmacia"

        val clausulaWhere = "nombre_farmacia = ?"

        val parametros = arrayOf(farmacia.nombreFar)

        val respuesta = dbWriteable.delete(
            nombreTabla,
            clausulaWhere,
            parametros
        )

        return if (respuesta == -1) false else true

    }

    fun actualizarFarmacia(farmacia:Farmacia): Boolean {
        // Base de datos de escritura
        val dbWriteable = writableDatabase
        val cv = ContentValues()
        // Valores de los campos
        cv.put("nombre_farmacia", farmacia.nombreFar)
        cv.put("direccion_farmacia", farmacia.direccionFar)
        val resultado = dbWriteable
            .update(
                "Farmacia", // Nombre de la tabla
                cv, // Valores a actualizarse
                "nombre_farmacia=?", // Where
                arrayOf(farmacia.nombreFar) // Parametros
            )
        dbWriteable.close()
        return if (resultado.toInt() == -1) false else true
    }
////////////////////////////////////////////////////////
    fun cargarTipoMedicina():ArrayList<TipoMedicina>{
        val statement = "select * from TipoMedicina"
        val lstTipoMed = ArrayList<TipoMedicina>()
        val dbReadable = readableDatabase
        val resultado = dbReadable.rawQuery(statement, null)
        if (resultado.moveToFirst()) {

            do {
                val respuestaTipoMed = TipoMedicina(null)
                respuestaTipoMed.nombreTipMed=resultado.getString(1)
                lstTipoMed.add(respuestaTipoMed)
            } while (resultado.moveToNext())
        }
        resultado.close()
        dbReadable.close()
        return lstTipoMed

    }



    fun crearTipoMedicina(tipoMed:TipoMedicina): Boolean {

        // Base de datos de escritura
        val dbWriteable = writableDatabase
        val cv = ContentValues()
        // Valores de los campos
        cv.put("nombre_tipo_med", tipoMed.nombreTipMed)
        val resultado: Long = dbWriteable
            .insert(
                "TipoMedicina", // Nombre de la tabla
                null,
                cv)
        dbWriteable.close()
        return if (resultado.toInt() == -1) false else true
    }
    ///////////////////////////////////////////////////////////////////
    fun cargarMedicina():ArrayList<Medicina>{
        val statement = "select * from Medicina"
        val lstMedicina = ArrayList<Medicina>()
        val dbReadable = readableDatabase
        val resultado = dbReadable.rawQuery(statement, null)
        if (resultado.moveToFirst()) {

            do {
                val respuestaMedicina = Medicina(null, null,null,null,null)
                respuestaMedicina.nombreMed=resultado.getString(1)
                respuestaMedicina.codigoMed=resultado.getString(2)
                respuestaMedicina.precioMed=resultado.getString(3)
                respuestaMedicina.observacionMed=resultado.getString(4)
                respuestaMedicina.dosisMed=resultado.getString(5)
                lstMedicina.add(respuestaMedicina)
            } while (resultado.moveToNext())
        }
        resultado.close()
        dbReadable.close()
        return lstMedicina

    }



    fun crearMedicina(medicina:Medicina): Boolean {

        // Base de datos de escritura
        val dbWriteable = writableDatabase
        val cv = ContentValues()
        // Valores de los campos
        cv.put("nombre_medicina", medicina.nombreMed)
        cv.put("codigo_medicina", medicina.codigoMed)
        cv.put("precio_medicina", medicina.precioMed)
        cv.put("observacion_medicina", medicina.observacionMed)
        cv.put("dosis_medicina", medicina.dosisMed)
        val resultado: Long = dbWriteable
            .insert(
                "Medicina", // Nombre de la tabla
                null,
                cv)
        dbWriteable.close()
        return if (resultado.toInt() == -1) false else true
    }
}
