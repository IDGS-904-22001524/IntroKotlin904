package com.waldoz_x.introkotlin904.traductor

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.waldoz_x.introkotlin904.R
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.IOException


class BuscarPalabras : AppCompatActivity() {

    private val NOMBRE_ARCHIVO_TRADUCCIONES = "traducciones.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_buscar_palabras)

        val btnRegresarMenu = findViewById<Button>(R.id.btnRegresarAlMenu)
        val btnBuscarPalabra = findViewById<Button>(R.id.btnBuscarPalabra)
        val radioBtnEspañol = findViewById<RadioButton>(R.id.radioBtnEspañol)
        val radioBtnIngles = findViewById<RadioButton>(R.id.radioBtnIngles)
        val radioGroupIdioma = findViewById<RadioGroup>(R.id.radioGroupIdioma)
        val txtResultadoBusqueda = findViewById<TextView>(R.id.txtResultadoBusqueda)
        val txtBuscarPalabra = findViewById<EditText>(R.id.txtBuscarPalabra) // Cambiado a EditText

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnRegresarMenu.setOnClickListener {
            navigateToMenus()
        }

        btnBuscarPalabra.setOnClickListener {
            val palabraIngresada = txtBuscarPalabra.text.toString().trim()
            if (palabraIngresada.isEmpty()) {
                Toast.makeText(this, "Por favor, ingresa una palabra.", Toast.LENGTH_SHORT).show()
                txtResultadoBusqueda.text = "Por favor, ingresa una palabra."
                return@setOnClickListener
            }

            val idiomaSeleccionado = when (radioGroupIdioma.checkedRadioButtonId) {
                R.id.radioBtnEspañol -> "Español"
                R.id.radioBtnIngles -> "Inglés"
                else -> {
                    Toast.makeText(this, "Selecciona un idioma.", Toast.LENGTH_SHORT).show()
                    txtResultadoBusqueda.text = "Selecciona un idioma."
                    return@setOnClickListener
                }
            }

            buscarTraduccion(palabraIngresada, idiomaSeleccionado, txtResultadoBusqueda)
        }
    }

    private fun navigateToMenus() {
        val intent = Intent(this, MenuTraductor::class.java)
        startActivity(intent)
    }

    private fun buscarTraduccion(palabra: String, idioma: String, txtResultadoBusqueda: TextView) {
        try {
            openFileInput(NOMBRE_ARCHIVO_TRADUCCIONES).use { fis ->
                BufferedReader(InputStreamReader(fis)).use { reader ->
                    var encontrado = false
                    reader.lineSequence().forEach { line ->
                        val partes = line.split(",")
                        if (partes.size == 2) {
                            val palabraEspañol = partes[0].trim()
                            val palabraIngles = partes[1].trim()

                            when (idioma) {
                                "Español" -> {
                                    if (palabraIngles.equals(palabra, ignoreCase = true)) {
                                        txtResultadoBusqueda.text = "Traducción al español: $palabraEspañol"
                                        encontrado = true
                                        return@forEach // Salir del bucle al encontrar la palabra
                                    }
                                }
                                "Inglés" -> {
                                    if (palabraEspañol.equals(palabra, ignoreCase = true)) {
                                        txtResultadoBusqueda.text = "Traducción al inglés: $palabraIngles"
                                        encontrado = true
                                        return@forEach // Salir del bucle al encontrar la palabra
                                    }
                                }
                            }
                        }
                    }

                    if (!encontrado) {
                        txtResultadoBusqueda.text = "Palabra no encontrada."
                        Toast.makeText(this, "Palabra no encontrada.", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
            txtResultadoBusqueda.text = "Error al leer el archivo de traducciones."
            Toast.makeText(this, "Error al leer el archivo: ${e.message}", Toast.LENGTH_LONG).show()
        }
    }
}