package com.waldoz_x.introkotlin904.TemasKotlin

/*

Range = ..

1..4 = 1,2,3,4 Incrementos de 1 en 1
1..<4= 1,2,3 Incrementos de 1 pero nunca toca el numero 4
4 downTo = 1 = 4,3,2,1
1..5 step 2 = 1,3,5 Incrementos de 2 en 2
'a'..'f'=a,b,c,d,e Se puede tambien con letras
 */

fun main() {
    for (i in 1..4) {
        println(i)
    }

    val figuras = listOf("triangle", "square", "circle")
    for (figura in figuras) {
        println(figura)
    }


    //While

    var numero = 0
    while (numero < 5) {
        println(numero)
        numero++

    }

}