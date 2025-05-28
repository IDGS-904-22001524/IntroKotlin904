package com.waldoz_x.introkotlin904.Menu

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.waldoz_x.introkotlin904.R
import com.waldoz_x.introkotlin904.tema1App.CinepolisActivity
import com.waldoz_x.introkotlin904.tema1App.Ejemplo1Activity
import com.waldoz_x.introkotlin904.tema2App.Ejemplo2Activity
import com.waldoz_x.introkotlin904.tema3App.Ejemplo3Activity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)

        val btnEjemplo1 = findViewById<Button>(R.id.btnEjemplo1)
        val btnCine = findViewById<Button>(R.id.btnCine)
        val btnEjemplo2 = findViewById<Button>(R.id.btnEjemplo2)
        val btnRandom = findViewById<Button>(R.id.btnRandom)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnEjemplo1.setOnClickListener {
            navigateToEjemplo1()
        }

        btnCine.setOnClickListener {
            navigateToCine()
        }

        btnEjemplo2.setOnClickListener {
            navigateToEjemplo2()
        }
        btnRandom.setOnClickListener {
            navigateToRandom()
        }


    }




    private fun navigateToEjemplo1() {
        val intent = Intent(this, Ejemplo1Activity ::class.java)
        startActivity(intent)
    }

    private fun navigateToCine(){
        val intent = Intent(this, CinepolisActivity ::class.java)
        startActivity(intent)
    }
    private fun navigateToEjemplo2() {
        val intent = Intent(this, Ejemplo2Activity ::class.java)
        startActivity(intent)
    }

    private fun navigateToRandom() {
        val intent = Intent(this, Ejemplo3Activity ::class.java)
        startActivity(intent)

    }

}