package com.example.quizapp.model

import com.example.quizapp.R

data class Pregunta(val id: String, val pregunta: String, val imagen: Int,val opciones: List<String>, val correcta: Int)

val preguntasSample = mutableListOf<Pregunta>(
        Pregunta("0001", "En que provincia se encuentra la peninsula Valdés?", R.drawable.valdes, listOf("Chubut", "Rio Negro", "Santa Cruz", "CABA"), 0),
        Pregunta("0002", "Que seleccion nacional quedó en segundo lugar en el mundial 2022?", R.drawable.mbappe, listOf("Croacia", "Francia", "Brazil", "Inglaterra"), 1),
        Pregunta("0003", "En que ciudad nació Lionel Messi?", R.drawable.messi, listOf("Mar del Plata", "Posadas", "Rio Cuarto", "Rosario"), 3),
        Pregunta("0004", "De que artista es la cancion 'Pelotuda'?", R.drawable.pelotuda, listOf("Serú Giran", "Dillom", "Miranda", "Lali"), 1),
        Pregunta("0005", "Completá la letra de la cancion 'Por eso esperaba, con la carita empapada, que llegaras con ...'",R.drawable.lodvg, listOf("Fideos", "Un gatito", "Rosas", "Olor a porro"), 2)
)

val cuestionarioSample = Cuestionario(preguntasSample)

data class Cuestionario(var preguntas: MutableList<Pregunta>) {
    fun obtenerPregunta(pocicion: Int): Pregunta {
        return preguntas[pocicion]
    }
    fun obtenerTodas(): MutableList<Pregunta> {
        return preguntas
    }

    fun agregarPregunta(pregunta: Pregunta) {
        preguntas.add(pregunta)
    }

    fun cantidad(): Int {
        return preguntas.size
    }

}