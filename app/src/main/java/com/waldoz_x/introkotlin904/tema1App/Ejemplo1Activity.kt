package com.waldoz_x.introkotlin904.tema1App

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.semantics.text
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.waldoz_x.introkotlin904.R

class Ejemplo1Activity : AppCompatActivity() {

    lateinit var txtResultado: TextView
    lateinit var ediTxt1: TextView
    lateinit var ediTxt2: TextView
    lateinit var btnSumar: RadioButton
    lateinit var btnRestar: RadioButton
    lateinit var btnMultiplicar: RadioButton
    lateinit var btnDividir: RadioButton
    lateinit var btnActivity: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejemplo1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        txtResultado = findViewById<TextView>(R.id.txtResultado)
        ediTxt1 = findViewById<TextView>(R.id.ediTxt1)
        ediTxt2 = findViewById<TextView>(R.id.ediTxt2)
        btnSumar = findViewById<RadioButton>(R.id.rButtonSumar)
        btnRestar = findViewById<RadioButton>(R.id.rButtonRestar)
        btnMultiplicar = findViewById<RadioButton>(R.id.rButtonMultiplicar)
        btnDividir = findViewById<RadioButton>(R.id.rButtonDividir)
        btnActivity = findViewById<Button>(R.id.btnActivity)


        btnActivity.setOnClickListener {
            val intent = Intent(this, CinepolisActivity::class.java)
            startActivity(intent)
        }

    }

    fun calcular(view: android.view.View) {
        if (ediTxt1.text.isEmpty() || ediTxt2.text.isEmpty()) {
            txtResultado.text = "Error: Ingrese valores en ambos campos"
        }else if (btnSumar.isChecked) {
            sumar(view)
        }else if (btnRestar.isChecked) {
            restar(view)
        }else if (btnMultiplicar.isChecked) {
            multiplicar(view)
        }else if (btnDividir.isChecked) {
            dividir(view)
        }
    }


    fun sumar(view: android.view.View) {
        try {
            val valor1 = ediTxt1.text.toString().toDouble()
            val valor2 = ediTxt2.text.toString().toDouble()
            val resultado = valor1 + valor2
            txtResultado.text = resultado.toString()
        } catch (e: NumberFormatException) {
            txtResultado.text = "Error: Ingrese números válidos"
        }        }


    fun restar(view: android.view.View) {
        try {
            val valor1 = ediTxt1.text.toString().toDouble()
            val valor2 = ediTxt2.text.toString().toDouble()
            val resultado = valor1 - valor2
            txtResultado.text = resultado.toString()
        } catch (e: NumberFormatException) {
            txtResultado.text = "Error: Ingrese números válidos"
        }        }

    fun multiplicar(view: android.view.View) {
        try {
            val valor1 = ediTxt1.text.toString().toDouble()
            val valor2 = ediTxt2.text.toString().toDouble()
            val resultado = valor1 * valor2
            txtResultado.text = resultado.toString()
        } catch (e: NumberFormatException) {
            txtResultado.text = "Error: Ingrese números válidos"
        }
    }
    fun dividir(view: android.view.View) {
        try {
            val valor1 = ediTxt1.text.toString().toDouble()
            val valor2 = ediTxt2.text.toString().toDouble()
            val resultado = valor1 / valor2
            txtResultado.text = resultado.toString()
        } catch (e: NumberFormatException) {
            txtResultado.text = "Error: Ingrese números válidos"
        }
    }


}