package com.waldoz_x.introkotlin904.Palindromo

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.waldoz_x.introkotlin904.R

class DatosPalindromoActivity : AppCompatActivity() {

    private lateinit var txtCadenaOriginal: TextView
    private lateinit var txtCadenaReversa: TextView
    private lateinit var txtVocalesCadena: TextView
    private lateinit var txtNConsonantes: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_datos_palindromo)

        txtCadenaOriginal = findViewById(R.id.txtCadenaOriginal)
        txtCadenaReversa = findViewById(R.id.txtCadenaReversa)
        txtVocalesCadena = findViewById(R.id.txtVocalesCadena)
        txtNConsonantes = findViewById(R.id.txtNConsonantes)

        val cadena = intent.getStringExtra("cadena") ?: ""
        txtCadenaOriginal.text = "Cadena Original: $cadena"

        val cadenaReversa = cadena.reversed()
        txtCadenaReversa.text = "Cadena escrita al revés: $cadenaReversa"


        val (vocales, consonantes) = contarVocalesYConsonantes(cadena)
        txtVocalesCadena.text = "Vocales: $vocales"
        txtNConsonantes.text = "Consonantes: $consonantes"


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun contarVocalesYConsonantes(cadena: String): Pair<Int, Int> {
        val vocales = "aeiouáéíóú"
        var contadorVocales = 0
        var contadorConsonantes = 0

        for (char in cadena.toLowerCase()) {
            if (char.isLetter()) {
                if (char in vocales) {
                    contadorVocales++
                } else {
                    contadorConsonantes++
                }
            }
        }

        return Pair(contadorVocales, contadorConsonantes)
    }
}