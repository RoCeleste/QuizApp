package com.example.quizapp.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.quizapp.R

class FinActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fin)

        var textViewNombre = findViewById<TextView>(R.id.textViewNombre)
        textViewNombre.text = getIntent().getStringExtra("nombre")

        var puntos = getIntent().getStringExtra("puntos")
        var cantidad = getIntent().getStringExtra("cantidad")
        var puntaje = findViewById<TextView>(R.id.puntaje)
        puntaje.text = puntos + "/" + cantidad

        var cerrar = findViewById<Button>(R.id.cerrar)
        cerrar.setOnClickListener {
            finish()
        }
    }
}