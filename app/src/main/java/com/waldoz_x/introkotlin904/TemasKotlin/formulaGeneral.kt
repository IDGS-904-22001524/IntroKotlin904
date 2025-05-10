package com.waldoz_x.introkotlin904.TemasKotlin

// Permite realizar el calculo de la formula general (validar raices negativas y divisiones por cero), y pedir los valores de a,b,c si sale 0 entonces vuelva a pedir y si es correcto se termina el programa


import kotlin.math.sqrt

fun main() {
    var a: Double
    do {
        println("Ingresa el valor de a (no puede ser 0):")
        a = readLine()?.toDoubleOrNull() ?: 0.0
    } while (a == 0.0)

    println("Ingresa el valor de b:")
    val b = readLine()?.toDoubleOrNull() ?: 0.0

    println("Ingresa el valor de c:")
    val c = readLine()?.toDoubleOrNull() ?: 0.0

    val discriminante = b * b - 4 * a * c

    when {
        discriminante < 0 -> println("No hay raíces reales ")
        discriminante == 0.0 -> {
            val x = -b / (2 * a)
            println("Solo hay una raíz real: $x")
        }
        else -> {
            val raiz = Math.sqrt(discriminante)
            val x1 = (-b + raiz) / (2 * a)
            val x2 = (-b - raiz) / (2 * a)
            println("Las raíces son: $x1 y $x2")
        }
    }
}