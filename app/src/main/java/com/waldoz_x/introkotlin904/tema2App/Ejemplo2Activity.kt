package com.waldoz_x.introkotlin904.tema2App

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.waldoz_x.introkotlin904.R

class Ejemplo2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_ejemplo3)
        val btnStart2 = findViewById<Button>(R.id.btnStart2)
        val edtName = findViewById<EditText>(R.id.edtName)

        btnStart2.setOnClickListener {
            val name = edtName.text.toString()
            val intent = Intent(this, ResultadoActivity::class.java)
            intent.putExtra("name", name)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}