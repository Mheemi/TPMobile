package com.ifts18.tpfinal.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ifts18.tpfinal.databinding.FragmentAboutBinding

class AboutFragment : Fragment() {

    private var _binding: FragmentAboutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAboutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.tvPolicy.text = """
            Esta aplicación fue desarrollada con fines académicos para facilitar el seguimiento de la cursada por parte de los estudiantes.

            El uso de esta app es exclusivo para alumnos del Instituto de Formación Técnica N°18.

            No se recopilan datos personales ni se realiza almacenamiento en la nube. Toda la información mostrada es simulada y utilizada solo con fines educativos.

            Al utilizar esta aplicación, el usuario acepta las condiciones aquí expuestas.
        """.trimIndent()

        binding.tvVersion.text = "Versión\n1.0"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
