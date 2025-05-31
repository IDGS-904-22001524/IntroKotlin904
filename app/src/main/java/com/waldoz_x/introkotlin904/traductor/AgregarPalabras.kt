package com.waldoz_x.introkotlin904.traductor

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.focus.requestFocus
import androidx.compose.ui.semantics.text
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.waldoz_x.introkotlin904.R
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStreamReader
import kotlin.concurrent.write
import kotlin.text.clear

class AgregarPalabras : AppCompatActivity() {

    private val NOMBRE_ARCHIVO_TRADUCCIONES = "traducciones.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_agregar_palabras)

        val btnRegresarMenu = findViewById<Button>(R.id.btnRegresarMenu) // Regresar al menú
        val btnGuardarPalabra = findViewById<Button>(R.id.btnGuardarPalabra) // Guardar palabra
        val txtPalabraEspañol = findViewById<EditText>(R.id.txtPalabraEspañol) // Texto ingresado por el usuario
        val txtPalabraIngles = findViewById<EditText>(R.id.txtPalabraIngles) // Texto ingresado por el usuario
        val txtMensajeResultado = findViewById<TextView>(R.id.txtMensajeResultado) // Resultado de la búsqueda

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnRegresarMenu.setOnClickListener {
            navigateToMenu()
        }

        btnGuardarPalabra.setOnClickListener {
            val palabraEspañol = txtPalabraEspañol.text.toString()
            val palabraIngles = txtPalabraIngles.text.toString()
            if (palabraEspañol.isNotEmpty() && palabraIngles.isNotEmpty()) {
                guardarTraduccion(palabraEspañol, palabraIngles, txtPalabraEspañol, txtPalabraIngles, txtMensajeResultado)
            } else {
                txtMensajeResultado.text = "Por favor, ingresa una palabra en ambos campos."
                Toast.makeText(this, "Por favor, ingresa una palabra en ambos campos.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun navigateToMenu() {
        val intent = Intent(this, MenuTraductor::class.java)
        startActivity(intent)
    }

    private fun guardarTraduccion(
        palabraEspañol: String,
        palabraIngles: String,
        txtPalabraEspañol: EditText,
        txtPalabraIngles: EditText,
        txtMensajeResultado: TextView
    ) {
        val lineaParaGuardar = "$palabraEspañol,$palabraIngles\n"

        try {
            openFileOutput(NOMBRE_ARCHIVO_TRADUCCIONES, Context.MODE_APPEND).use { fos ->
                fos.write(lineaParaGuardar.toByteArray())
            }

            txtMensajeResultado.text = "Palabra guardada: $palabraEspañol - $palabraIngles"
            Toast.makeText(this, "Palabra guardada exitosamente", Toast.LENGTH_SHORT).show()

            txtPalabraEspañol.setText("")
            txtPalabraIngles.setText("")
            txtPalabraEspañol.requestFocus()

        } catch (e: IOException) {
            e.printStackTrace()
            txtMensajeResultado.text = "Error al guardar la palabra."
            Toast.makeText(this, "Error al guardar la palabra: ${e.message}", Toast.LENGTH_LONG).show()
        }
    }
}