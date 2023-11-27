package com.example.quizapp.UI

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import com.example.quizapp.R
import com.example.quizapp.model.Pregunta
import com.example.quizapp.model.cuestionarioSample
import com.example.quizapp.model.preguntasSample
import java.sql.Time
import java.util.concurrent.TimeUnit

class PreguntasActivity : AppCompatActivity() {

    private lateinit var contador: TextView
    private lateinit var barra: SeekBar
    private lateinit var pregunta: TextView
    private lateinit var imagen: ImageView
    private lateinit var opcion1: Button
    private lateinit var opcion2: Button
    private lateinit var opcion3: Button
    private lateinit var opcion4: Button
    private var pregunta_actual: Pregunta? = null
    private var correcta: Int = 0
    lateinit var nombre: String

    var muestra = cuestionarioSample
    var cantidad = muestra.cantidad()
    var posActual = 0

    var puntaje = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preguntas)
        nombre = getIntent().getStringExtra("nombre")!!


        contador = findViewById<TextView>(R.id.contador)
        barra = findViewById<SeekBar>(R.id.barra)
        pregunta = findViewById<TextView>(R.id.pregunta)
        imagen = findViewById<ImageView>(R.id.imagen)
        opcion1 = findViewById<Button>(R.id.opcion1)
        opcion2 = findViewById<Button>(R.id.opcion2)
        opcion3 = findViewById<Button>(R.id.opcion3)
        opcion4 = findViewById<Button>(R.id.opcion4)

        displayPregunta()
        opcion1.setOnClickListener {
            evaluarRespuestas(0)
        }
        opcion2.setOnClickListener {
            evaluarRespuestas(1)
        }
        opcion3.setOnClickListener {
            evaluarRespuestas(2)
        }
        opcion4.setOnClickListener {
            evaluarRespuestas(3)
        }

    }

    fun displayPregunta() {

        opcion1.setBackgroundColor(getColor(R.color.blue))
        opcion2.setBackgroundColor(getColor(R.color.blue))
        opcion3.setBackgroundColor(getColor(R.color.blue))
        opcion4.setBackgroundColor(getColor(R.color.blue))

        var actual = muestra.obtenerPregunta(posActual)

        barra.progress = posActual
        pregunta.text = actual.pregunta
        imagen.setImageResource(actual.imagen)
        opcion1.text = actual.opciones[0]
        opcion2.text = actual.opciones[1]
        opcion3.text = actual.opciones[2]
        opcion4.text = actual.opciones[3]
        pregunta_actual = actual
        correcta = actual.correcta

    }

    fun evaluarRespuestas(seleccionada: Int) {
        if (seleccionada == correcta) {
            puntaje++
            when (seleccionada) {
                0 -> opcion1.setBackgroundColor(getColor(R.color.green))
                1 -> opcion2.setBackgroundColor(getColor(R.color.green))
                2 -> opcion3.setBackgroundColor(getColor(R.color.green))
                3 -> opcion4.setBackgroundColor(getColor(R.color.green))
            }
        } else {
            when (seleccionada) {
                0 -> opcion1.setBackgroundColor(getColor(R.color.red))
                1 -> opcion2.setBackgroundColor(getColor(R.color.red))
                2 -> opcion3.setBackgroundColor(getColor(R.color.red))
                3 -> opcion4.setBackgroundColor(getColor(R.color.red))
            }
        }

        if (posActual < cantidad - 1) {
            posActual++
            displayPregunta()
        } else {
            var fin_intent = Intent(this@PreguntasActivity, FinActivity::class.java)
            fin_intent.putExtra("puntos", puntaje.toString())
            fin_intent.putExtra("cantidad", cantidad.toString())
            fin_intent.putExtra("nombre", nombre)
            startActivity(fin_intent)
            finish()
        }
    }
}