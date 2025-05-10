package com.waldoz_x.introkotlin904.TemasKotlin

/// Operaciones basicas y mostrar el menu (5 salir) , siempre mostrar el menu
fun main(){
    while (true){
        println("__________Menu__________")
        println("1. Hacer una suma")
        println("2. Hacer una resta")
        println("3. Hacer una multiplicacion")
        println("4. Hacer una division")
        println("5. Salir")
        println("________________________")

        println("Querido Usuario ingrese una opcion porfavor")
        val opcion = readln().toInt()


        if (opcion == 5 || opcion < 1 || opcion > 5 || opcion == null  ) {
            println("Gracias por usar el programa")
            break
        }

        println("Ingrese el primer numero")
        val num1 = readln().toInt()
        println("Ingrese el segundo numero")
        val num2 = readln().toInt()

        val suma = num1 + num2
        val resta = num1 - num2
        val multiplicacion = num1 * num2
        val division = num1 / num2


        when (opcion) {
            1 -> {
                println("________________________")
                println("Has elegido la opción suma y el resultado es $suma")
                println("________________________")

            }

            2 -> {
                println("________________________")
                println("Has elegido la opción resta y el resultado es $resta")
                println("________________________")

            }

            3 -> {
                println("________________________")
                println("Has elegido la opción multiplicación y el resultado es $multiplicacion")
                println("________________________")

            }

            4 -> {
                if (num2 != 0 && num1 != 0) {
                    println("________________________")
                    println("Has elegido la opción división y el resultado es $division")
                } else {
                    println("No se puede dividir entre cero.")
                }
            }

            else -> println("Oups escogiste una opción no válida")
        }
    }
}