package com.waldoz_x.introkotlin904.TemasKotlin

fun main() {
    /*
    List
    MutableList
    Set
    MutableSet
    Map
    MutableMap

     */

//    var readOnlyShapes = listOf("triangle", "square", "circle")
//    println(readOnlyShapes)
//
//    var mutableFiguras = mutableListOf("triangle", "square", "circle")
//    val readOnlyFiguras = listOf("triangle", "square", "circle")
//    mutableFiguras.add("pentagon")
//    println(mutableFiguras)
//

//
//    val coches= mapOf("uno" to "Toyota", "dos" to "Ford", "tres" to "BMW")
//    println(coches)
//    val coches2= mutableMapOf("uno" to "Toyota", "dos" to "Ford", "tres" to "BMW")
//    println(coches2)


    val readOnlyFiguras = listOf("triangle", "square", "circle")
    println(readOnlyFiguras)
    println("La primera figura es ${readOnlyFiguras[0]}")
    println("El primer elemento es ${readOnlyFiguras.first()}")
    println("Numero de elementos ${readOnlyFiguras.count()} items en la lista")
    println("Circulo" in readOnlyFiguras)
    println(readOnlyFiguras)
    //readOnlyFiguras.add("pentagon")
    var figura: MutableList<String> = mutableListOf("triangle2", "square2", "circle2")
    println(figura)
    figura.add("pentagon")
    println(figura)
    figura.remove("triangle2")
    println(figura)
    figura.add("triangle3")
    println(figura)
    figura.remove("square2")
    println(figura)
}
