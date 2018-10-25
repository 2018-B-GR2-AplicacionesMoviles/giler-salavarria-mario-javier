package Base

import Modelo.Paciente
import Modelo.Tratamiento

class BaseDeDatosPaciente{
    companion object {
        val lstPaciente:ArrayList<Paciente> = ArrayList()
        fun agregarPaciente(paciente: Paciente){
            lstPaciente.add(paciente)
        }
        fun buscarPaciente(nombre:String): Paciente {
            var paciente= Paciente()
            for (item: Paciente in lstPaciente) {
                if(item.nombrePaciente.equals(nombre)){
                    println(item.nombrePaciente +"\t"+ item.enfermedadPaciente)
                    paciente=item
                }
            }
            return paciente
        }


        fun mostrarPacientes(){
            for (item: Paciente in lstPaciente){
                println(item.codigoPaciente+"\t"+item.nombrePaciente+"\t"+item.apellidoPaciente+"\t"+item.edadPaciente+
                        "\t"+item.estadoCivilPaciente+"\t"+item.domicilioPaciente+"\t"+item.telefonoPaciente+"\t"+item.grupoSanguineoPaciente
                        +"\t"+item.alergiasPaciente+"\t"+item.enfermedadPaciente)
            }
        }

        fun eliminarPacientes(nombre:String){
            for (i in lstPaciente.indices) {
                if(lstPaciente[i].nombrePaciente.equals(nombre)){
                    lstPaciente.removeAt(i)
                    println("Eliminado")
                }
            }
        }

        fun agregarTratamiento(){
            var nombrePaciente:String
            var tratamiento = Tratamiento()
            println("Ingrese nombre paciente")
            nombrePaciente= readLine()?.toString() as String
            tratamiento.paciente = buscarPaciente(nombrePaciente)
            println("Llenar tratamiento")
            print("Nombre del doctor")
            tratamiento.nombreDoctor= readLine()?.toString() as String
            print("Enfermedad del paciente")
            tratamiento.tratamientoEnfermedad = readLine()?.toString() as String
            print("Observación del paciente")
            tratamiento.observacion= readLine()?.toString() as String
            println(tratamiento.nombreDoctor +"\t"+ tratamiento.observacion +"\t"+ tratamiento.tratamientoEnfermedad +"\t"+ tratamiento.paciente.nombrePaciente)
        }


    }
}