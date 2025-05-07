package com.waldoz_x.introkotlin904.TemasKotlin

fun main(){
    println("Hola Mmundo!!")
    // Variables solo lectura val
    // Variables mutables var

    val a=4
    val b=8
    var c=10

    //A val no se le puede reasignar valores
    // a=10 Nos daria error
    //Pero a la variable Var si le podemos reasignar datos
    // c=234


    println(a)
    println("el valor de b es $b")
    println("el valor de b es ${c+2}")
    c= a+2
    c+=8
    c-=5
    c*8
    c/=2
    println("el valor de c es $c")

    val inline:String
    val num1:Int=23
    var num3:Int=12
    val string1:String="Hola Mundo"
    val num2:Double=23.5
    val num4:Float=23.5f
    num3=343

    var nombre:String="Carlos"
    var caracter:Char='a'









}