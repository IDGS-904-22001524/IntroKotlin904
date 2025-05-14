package com.waldoz_x.introkotlin904.tema1App

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.waldoz_x.introkotlin904.R

class Ejemplo2Activity : AppCompatActivity() {

    lateinit var txtResultado: TextView
    lateinit var ediTxt1: TextView
    lateinit var ediTxt2: TextView
    lateinit var btnVolverActivitys: Button
    lateinit var btnCalcular: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejemplo2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnVolverActivitys = findViewById<Button>(R.id.btnVolver)
        txtResultado = findViewById<TextView>(R.id.textView3)
        ediTxt1 = findViewById<TextView>(R.id.editTextNumberDecimal)
        ediTxt2 = findViewById<TextView>(R.id.editTextNumberDecimal2)
        btnCalcular = findViewById<Button>(R.id.btnCalcular)


        btnVolverActivitys.setOnClickListener {
            val intent = Intent(this, Ejemplo1Activity::class.java)
            startActivity(intent)
        }

        btnCalcular.setOnClickListener {
            calcular(it)
        }


    }

    fun calcular(view: android.view.View) {
        if (ediTxt1.text.isEmpty() || ediTxt2.text.isEmpty()) {
            txtResultado.text = "Error: Ingrese valores en ambos campos"
        }else {
        val resultado = multiplicarConSumas(ediTxt1.text.toString().toDouble(), ediTxt2.text.toString().toDouble())
            txtResultado.text = resultado.toString()
        }
    }

    fun multiplicarConSumas(numero1: Double, numero2: Double): Double {
        var resultado = 0.0
        val vecesASumar = kotlin.math.abs(numero2).toInt()

        if (vecesASumar == 0) {
            return 0.0
        }

        for (i in 1..vecesASumar) {
            resultado += numero1
            Toast.makeText(this, "Sumando: $resultado", Toast.LENGTH_SHORT).show()
        }

        if (numero2 < 0) {
            resultado *= -1
        }

        return resultado
    }

}