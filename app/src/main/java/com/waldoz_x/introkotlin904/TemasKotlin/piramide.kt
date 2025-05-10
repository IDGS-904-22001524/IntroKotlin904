package com.waldoz_x.introkotlin904.TemasKotlin

// Permitir realizar una piramide de asterisco, siempre preguntar el numero despues de mostrar la piramide y cuando se ponga 0 se termine (Do while solamente)
//fun noEsAsi() {
//    var nFilas: Int
//
//    do {
//        println("Querido usuario ingresa el número de filas que quieres crear para la pirámide o para salir del programa solo ingrese 0")
//        nFilas = readLine()?.toIntOrNull() ?: 0
//
//        // No se si debia ser asi asi que se lo hago como el ejemplo que puso
//        if (nFilas > 0) {
//
//            for (i in 1..nFilas) {
//                for (j in 1..(nFilas - i)) {
//                    print(" ")
//                }
//                for (k in 1..(2 * i - 1)) {
//                    print("*")
//                }
//                println()
//            }
//            // aqui inicia el que explico usted
//        } else if (nFilas < 0) {
//            println("________________________")
//
//            println("Usuario por favor, ingresa un número positivo o 0 para salir no puedo hacer una piramide con un numero negativo tonoto")
//
//            println("________________________")
//
//        }
//
//    } while (nFilas != 0)
//    println("________________________")
//
//    println("Saliendo del programa... Gracias por usar el programa")
//
//    println("________________________")
//
//}


fun main() {
    var numFilas: Int

    do {
        println("Ingresa el número de filas para la pirámide o puedes ingresar 0 para salir:")
        numFilas = readLine()?.toIntOrNull() ?: 0

        if (numFilas > 0) {

            for (i in 1..numFilas) {
                for (k in 1..i) {
                    print("*")
                }
                println()
            }
        } else if (numFilas < 0) {
            println("Por favor, ingresa un número positivo o 0 para salir.")
        }

    } while (numFilas != 0)

    println("Saliendo del programa.")
}