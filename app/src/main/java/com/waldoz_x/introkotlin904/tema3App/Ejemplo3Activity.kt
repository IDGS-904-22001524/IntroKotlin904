package com.waldoz_x.introkotlin904.tema3App

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

class Ejemplo3Activity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var textView: TextView
    private lateinit var button: Button
    private var num=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejemplo4)

        editText = findViewById(R.id.ed0)
        textView = findViewById(R.id.tv1)
        button = findViewById(R.id.button)

        num=(Math.random()*100001).toInt()
        val cadena=num.toString().toString()
        val notificacion = Toast.makeText(applicationContext,cadena, Toast.LENGTH_LONG)
        notificacion.show()

        button.setOnClickListener {
            control(it)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


    }

    fun control(view: android.view.View) {
        val valorIngresado: String = editText.text.toString()
        val valor = valorIngresado.toInt()
        if (valor == num) {

            val notificacion = Toast.makeText(applicationContext, "Correcto", Toast.LENGTH_LONG)
            notificacion.show()

        }else{
            val notificacion = Toast.makeText(applicationContext, "Incorrecto", Toast.LENGTH_LONG)
            notificacion.show()
        }
    }


}