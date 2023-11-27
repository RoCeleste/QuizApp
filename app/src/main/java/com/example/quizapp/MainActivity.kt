package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.quizapp.UI.PreguntasActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var botonIngresar = findViewById<Button>(R.id.botonIngresar)
        var nombre = findViewById<EditText>(R.id.nombre)

        botonIngresar.setOnClickListener {
            if (!nombre.text.isEmpty()) {
                intent = Intent(this@MainActivity, PreguntasActivity::class.java)
                intent.putExtra("nombre", nombre.text.toString())
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this@MainActivity, "Por favor ingresa tu nombre", Toast.LENGTH_LONG).show()
            }
        }
    }
}