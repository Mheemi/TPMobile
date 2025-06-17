package com.ifts18.tpfinal.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ifts18.tpfinal.R
import com.ifts18.tpfinal.adapters.QuickAccessAdapter
import com.ifts18.tpfinal.databinding.FragmentHomeBinding
import com.ifts18.tpfinal.models.QuickAccessItem

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val quickAccessItems = listOf(
        QuickAccessItem(R.drawable.ic_assessment_24, "Calificaciones", "Ver notas"),
        QuickAccessItem(R.drawable.ic_schedule_24, "Vencimientos", "Próximas fechas"),
        QuickAccessItem(R.drawable.ic_calendar_24, "Cronograma", "Horarios"),
        QuickAccessItem(R.drawable.ic_check_circle_24, "Asistencias", "Mi presentismo")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.tvWelcome.text = getString(R.string.welcome_title)
        binding.tvSubtitle.text = getString(R.string.welcome_subtitle)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.recyclerQuickAccess.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerQuickAccess.adapter = QuickAccessAdapter(quickAccessItems) { item ->
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
