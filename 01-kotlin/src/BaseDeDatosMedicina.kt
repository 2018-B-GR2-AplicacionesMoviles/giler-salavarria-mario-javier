class BaseDeDatosMedicina{
    companion object {
        val lstMedicina:ArrayList<Medicina> = ArrayList()
        fun agregarMedicina(medicina:Medicina){
            lstMedicina.add(medicina)
        }
        fun buscarMedicina(codigo:String){
            for (item: Medicina  in lstMedicina) {
                if(item.codigoMedicina.equals(codigo)){
                    println(item.nombreMedicina)
                }
            }
        }

        fun mostrarMedicinas(){
            for (item:Medicina in lstMedicina){
                println(item.codigoMedicina +"\t"+ item.nombreMedicina)
            }
        }

        fun eliminarMedicina(codigo:String){
            for (i in lstMedicina.indices) {
                if(lstMedicina[i].codigoMedicina.equals(codigo)){
                    lstMedicina.removeAt(i)
                    println("Eliminado")
                }
            }
        }

    }
}