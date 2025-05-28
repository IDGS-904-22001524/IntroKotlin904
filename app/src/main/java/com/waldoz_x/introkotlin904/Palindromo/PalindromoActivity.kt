package com.waldoz_x.practicapalndromo.Palindromo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.waldoz_x.practicapalndromo.R

class PalindromoActivity : AppCompatActivity() {

    private lateinit var txtCadena: EditText
    private lateinit var btnAnalizarCadena: Button
    private lateinit var txtResultadosCadena: TextView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_palindromo)

        txtCadena = findViewById(R.id.txtCadena)
        btnAnalizarCadena = findViewById(R.id.btnAnalizarCadena)
        txtResultadosCadena = findViewById(R.id.txtResultadosCadena)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnAnalizarCadena.setOnClickListener {
            val cadena = txtCadena.text.toString().trim()
            if (cadena.isEmpty()) {
                txtResultadosCadena.text = "Por favor, ingresa una cadena."
                return@setOnClickListener
            }

            // Verificar si es un palíndromo
            val esPalindromo = esPalindromo(cadena)
            if (esPalindromo) {
                // Navegar a la segunda pantalla
                val intent = Intent(this, DatosPalindromoActivity::class.java)
                intent.putExtra("cadena", cadena)
                startActivity(intent)
            } else {
                txtResultadosCadena.text = "La cadena no es un palíndromo."
            }
        }
    }
    private fun esPalindromo(cadena: String): Boolean {
        val cadenaLimpia = cadena.replace("\\s".toRegex(), "").toLowerCase()
        return cadenaLimpia == cadenaLimpia.reversed()
    }
}



