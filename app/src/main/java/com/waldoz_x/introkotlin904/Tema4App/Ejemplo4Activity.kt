package com.waldoz_x.introkotlin904.Tema4App

import android.app.AlertDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.waldoz_x.introkotlin904.R
import java.io.FileNotFoundException

class Ejemplo4Activity : AppCompatActivity() {

    private val fileName="datos.txt"


    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejemplo5)
        val inputText = findViewById<EditText>(R.id.inputText)
        val outputText = findViewById<TextView>(R.id.outputText)
        val btnBorrar = findViewById<Button>(R.id.btnBorrar)
        val btnGuardar = findViewById<Button>(R.id.saveButton)
        val BtnLeer = findViewById<Button>(R.id.readButton)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnBorrar.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Confirmación")
            builder.setMessage("¿Estás seguro de que deseas borrar el contenido del archivo '$fileName'?")

            builder.setPositiveButton("Sí") { dialog, _ ->
                try {
                    openFileOutput(fileName, MODE_PRIVATE).use {
                        it.write("".toByteArray())
                    }
                    Toast.makeText(this, "Contenido de '$fileName' borrado", Toast.LENGTH_SHORT).show()
                } catch (e: Exception) {
                    e.printStackTrace()
                    Toast.makeText(this, "Error durante la operación de borrado.", Toast.LENGTH_SHORT).show()
                }
            }

            builder.setNegativeButton("No") { dialog, _ ->
                Toast.makeText(this, "Operación de borrado cancelada.", Toast.LENGTH_SHORT).show()
                dialog.dismiss() // Cierra el diálogo
            }

            val dialog = builder.create()
            dialog.show()
        }


        btnGuardar.setOnClickListener {
            val text = inputText.text.toString() + "\n"
            try {
                openFileOutput(fileName, MODE_APPEND).use {
                    it.write(text.toByteArray())
                }
                inputText.text.clear()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        BtnLeer.setOnClickListener {

            try{
                val contenido = openFileInput(fileName).bufferedReader().useLines { lines ->
                    lines.joinToString("\n")

            }
                outputText.text=contenido
            }catch (e:FileNotFoundException){

                outputText.text="Archivo no encontrado"

            }catch (e:Exception){

                e.printStackTrace()

            }

        }


    }

}