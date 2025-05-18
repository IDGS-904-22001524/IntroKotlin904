package com.waldoz_x.introkotlin904.tema1App

import android.net.Uri
import android.os.Bundle
import android.widget.EditText
import android.widget.MediaController
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import android.widget.VideoView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.waldoz_x.introkotlin904.R
import kotlin.math.min

class CinepolisActivity : AppCompatActivity() {

    private lateinit var VideoView: VideoView;
    private lateinit var txtResultadoFinal: TextView;
    private lateinit var txtNombre: EditText;
    private lateinit var txtNumeroCompradores: EditText;
    private lateinit var txtCantidad: EditText;
    private lateinit var radioButton: RadioButton;
    private lateinit var radioButton2: RadioButton;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cinepolis)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        VideoView = findViewById(R.id.vView)
        txtResultadoFinal = findViewById(R.id.txtResultadoFinal)
        txtNombre = findViewById(R.id.txtNombre)
        txtNumeroCompradores = findViewById(R.id.txtNuneroCompradores)
        txtCantidad = findViewById(R.id.txtCantidad)
        radioButton = findViewById(R.id.radioButton)
        radioButton2 = findViewById(R.id.radioButton2)


        val videoPath = "android.resource://" + packageName + "/" + R.raw.download
        val uri = Uri.parse(videoPath)
        VideoView.setVideoURI(uri)

        val mediaController = MediaController(this)
        mediaController.setAnchorView(VideoView)
        VideoView.setMediaController(mediaController)
        VideoView.start()

    }

    fun calcularBoletos(view: android.view.View) {
        val nombre = txtNombre.text.toString()
        val numeroCompradores = txtNumeroCompradores.text.toString().toInt()
        val cantidad = txtCantidad.text.toString().toInt()

        if (nombre.isEmpty() || numeroCompradores == 0 || cantidad == 0) {
            Toast.makeText(this, "Error: Ingrese valores válidos", Toast.LENGTH_SHORT).show()
            return
        }
        val limiteBoletos = numeroCompradores * 7
        if (cantidad > limiteBoletos) {
            Toast.makeText(this, "Error: La cantidad de boletos supera el límite", Toast.LENGTH_SHORT).show()
            return
        }

        val precioBoleto = 12.0
        var costoTotal = cantidad * precioBoleto
        if(cantidad > 5){
            costoTotal *= 0.85
        }else if(cantidad >= 3 && cantidad <= 5){
            costoTotal *= 0.90
        }

        if (radioButton.isChecked) {
            costoTotal *= 0.90
        } else if (radioButton2.isChecked) {
            Toast.makeText(this, "No hay descuento adicional", Toast.LENGTH_SHORT).show()
        } else {

            Toast.makeText(this, "Seleccione una opción para el descuento adicional", Toast.LENGTH_SHORT).show()
            return
        }

        val resultadoFinal = "Pagar: $${String.format("%.2f", costoTotal)}"
        txtResultadoFinal.text = resultadoFinal
    }
}



