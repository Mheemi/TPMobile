package com.ifts18.tpfinal.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ifts18.tpfinal.R
import com.ifts18.tpfinal.adapters.GradesAdapter
import com.ifts18.tpfinal.models.Grade
import com.ifts18.tpfinal.models.GradeStatus

class GradesFragment : Fragment() {

    private lateinit var recyclerGrades: RecyclerView
    private lateinit var gradesAdapter: GradesAdapter

    // Datos simulados de calificaciones
    private val gradesList = listOf(
        Grade(
            id = 1,
            title = "Trabajo Práctico 1",
            value = 7,
            status = GradeStatus.PROMOCIONADO,
            subjectId = 1
        ),
        Grade(
            id = 2,
            title = "Parcial 1",
            value = 6,
            status = GradeStatus.ZONA_PROMOCION,
            subjectId = 1
        ),
        Grade(
            id = 3,
            title = "Trabajo Práctico 2",
            value = 4,
            status = GradeStatus.REGULAR,
            subjectId = 1
        ),
        Grade(
            id = 4,
            title = "Parcial 2",
            value = 2,
            status = GradeStatus.LIBRE,
            subjectId = 1
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_grades, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inicializar vistas
        recyclerGrades = view.findViewById(R.id.recyclerGrades)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        gradesAdapter = GradesAdapter(gradesList)
        recyclerGrades.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = gradesAdapter
        }
    }
}