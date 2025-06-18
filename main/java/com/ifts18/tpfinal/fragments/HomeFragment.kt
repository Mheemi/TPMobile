package com.ifts18.tpfinal.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ifts18.tpfinal.R
import com.ifts18.tpfinal.adapters.QuickAccessAdapter
import com.ifts18.tpfinal.models.QuickAccessItem

class HomeFragment : Fragment() {

    private lateinit var tvWelcome: TextView
    private lateinit var tvSubtitle: TextView
    private lateinit var recyclerQuickAccess: RecyclerView

    private val quickAccessItems = listOf(
        QuickAccessItem(R.drawable.ic_assessment_24, "Calificaciones", "Ver notas"),
        QuickAccessItem(R.drawable.ic_schedule_24, "Vencimientos", "Próximas fechas"),
        QuickAccessItem(R.drawable.ic_calendar_24, "Cronograma", "Horarios"),
        QuickAccessItem(R.drawable.ic_check_circle_24, "Asistencias", "Mi presentismo")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inicializar vistas
        tvWelcome = view.findViewById(R.id.tvWelcome)
        tvSubtitle = view.findViewById(R.id.tvSubtitle)
        recyclerQuickAccess = view.findViewById(R.id.recyclerQuickAccess)

        tvWelcome.text = getString(R.string.welcome_title)
        tvSubtitle.text = getString(R.string.welcome_subtitle)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        recyclerQuickAccess.layoutManager = LinearLayoutManager(requireContext())
        recyclerQuickAccess.adapter = QuickAccessAdapter(quickAccessItems) { item ->
            handleQuickAccessClick(item)
        }
    }

    private fun handleQuickAccessClick(item: QuickAccessItem) {
        when (item.title) {
            "Calificaciones" -> {
                findNavController().navigate(R.id.nav_grades)
            }
            "Vencimientos" -> {
                findNavController().navigate(R.id.nav_deadlines)
            }
            "Cronograma" -> {
                findNavController().navigate(R.id.nav_schedule)
            }
            "Asistencias" -> {
                findNavController().navigate(R.id.nav_attendance)
            }
        }
    }
}
