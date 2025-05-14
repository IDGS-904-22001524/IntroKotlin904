package com.waldoz_x.introkotlin904.TemasKotlin

class Usuarios (){
    val materia:String=""
}

class USuarios2(val id:Int, val nombre:String){
    val materia:String=""
    fun hola() {
        println("Hola $nombre")

    }
}


fun main(){
    val alumno = Usuarios()
    val alumno2 = USuarios2(1,"Carlos")

    println(alumno2.id)
    println(alumno2.nombre)
    alumno2.hola()

}