package com.waldoz_x.introkotlin904.TemasKotlin

fun main() {

    saludo()
    suma(12,342)
    println("La resta de 12 y 34 es ${resta(12,34)}")
}

fun saludo(){
    println("Hola Mundo")
}

fun suma(val1:Int, val2:Int){
    println("El resultado de la suma es ${val1+val2}")
}

fun resta (a:Int, b:Int):Int{
    return a-b
}
