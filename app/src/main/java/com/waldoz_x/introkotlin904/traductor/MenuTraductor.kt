package com.waldoz_x.introkotlin904.traductor

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.waldoz_x.introkotlin904.R

class MenuTraductor : AppCompatActivity() {

    lateinit var btnAgregarPalabras : Button
    lateinit var btnBuscarPalabras : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu_traductor)
        btnAgregarPalabras = findViewById(R.id.btnCapturaPalabras)
        btnBuscarPalabras = findViewById(R.id.btnBuscarPalabras)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnAgregarPalabras.setOnClickListener {
            btnAgregarPalabras()
        }

        btnBuscarPalabras.setOnClickListener {
            btnBuscarPalabras()
        }

    }

    private fun btnBuscarPalabras() {
        val intent = Intent(this, BuscarPalabras::class.java)
        startActivity(intent)
    }

    private fun btnAgregarPalabras() {
        val intent = Intent(this, AgregarPalabras::class.java)
        startActivity(intent)
    }



}