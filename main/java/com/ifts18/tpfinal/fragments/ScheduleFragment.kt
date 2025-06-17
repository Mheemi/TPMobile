package com.ifts18.tpfinal.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ifts18.tpfinal.adapters.ScheduleAdapter
import com.ifts18.tpfinal.databinding.FragmentScheduleBinding
import com.ifts18.tpfinal.models.ScheduleItem

class ScheduleFragment : Fragment() {

    private var _binding: FragmentScheduleBinding? = null
    private val binding get() = _binding!!

    private val mockItems = listOf(
        ScheduleItem("LUNES", "Clases de Matemática"),
        ScheduleItem("MARTES", "Entrega TP2 de Base de Datos"),
        ScheduleItem("MIÉRCOLES", "Parcial de Programación"),
        ScheduleItem("JUEVES", "Sin actividades"),
        ScheduleItem("VIERNES", "Clases de Laboratorio")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentScheduleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.recyclerSchedule.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = ScheduleAdapter(mockItems)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
