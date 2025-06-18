package com.ifts18.tpfinal.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.ifts18.tpfinal.R

class AboutFragment : Fragment() {

    private lateinit var tvPolicy: TextView
    private lateinit var tvVersion: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_about, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inicializar vistas
        tvPolicy = view.findViewById(R.id.tvPolicy)
        tvVersion = view.findViewById(R.id.tvVersion)

        tvPolicy.text = """
            Esta aplicación fue desarrollada con fines académicos para facilitar el seguimiento de la cursada por parte de los estudiantes.

            El uso de esta app es exclusivo para alumnos del Instituto de Formación Técnica N°18.

            No se recopilan datos personales ni se realiza almacenamiento en la nube. Toda la información mostrada es simulada y utilizada solo con fines educativos.

            Al utilizar esta aplicación, el usuario acepta las condiciones aquí expuestas.
        """.trimIndent()

        tvVersion.text = "Versión\n1.0"
    }
}
