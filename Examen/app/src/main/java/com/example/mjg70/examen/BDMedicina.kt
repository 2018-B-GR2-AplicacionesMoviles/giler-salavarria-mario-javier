package com.example.mjg70.examen

class BDMedicina{
    companion object {
        val lstMedicina:ArrayList<Medicina> = ArrayList()
        fun agregarMedicina(medicina: Medicina){
            lstMedicina.add(medicina)
        }

        fun mostrarMedicinas():ArrayList<Medicina>{
           return lstMedicina
        }

        fun actualizarMedicina(medicina:Medicina){

            lstMedicina.forEach{
                if(it.nombreMed.equals(medicina.nombreMed)){
                    it.codigoMed=medicina.codigoMed
                    it.precioMed=medicina.precioMed
                    it.observacionMed=medicina.observacionMed
                    it.dosisMed=medicina.dosisMed
                }

            }
        }

        fun eliminarMedicina(nombre:String){
            for (i in lstMedicina.indices) {
                if(lstMedicina[i].nombreMed.equals(nombre)){
                    lstMedicina.removeAt(i)
                }
            }
        }

    }

}