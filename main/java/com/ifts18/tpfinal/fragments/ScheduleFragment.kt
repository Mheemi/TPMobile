package com.ifts18.tpfinal.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ifts18.tpfinal.R
import com.ifts18.tpfinal.adapters.ScheduleAdapter
import com.ifts18.tpfinal.models.ScheduleItem

class ScheduleFragment : Fragment() {

    private lateinit var recyclerSchedule: RecyclerView

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
    ): View? {
        return inflater.inflate(R.layout.fragment_schedule, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inicializar vistas
        recyclerSchedule = view.findViewById(R.id.recyclerSchedule)

        recyclerSchedule.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = ScheduleAdapter(mockItems)
        }
    }
}
