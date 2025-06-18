package com.ifts18.tpfinal.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ifts18.tpfinal.R
import com.ifts18.tpfinal.adapters.DeadlinesAdapter
import com.ifts18.tpfinal.models.DeadlineItem

class DeadlinesFragment : Fragment() {

    private lateinit var recyclerDeadlines: RecyclerView

    private val mockItems = listOf(
        DeadlineItem("Trabajo Práctico 2", "14 de marzo"),
        DeadlineItem("Parcial 1", "30 de marzo"),
        DeadlineItem("Trabajo Práctico 3", "7 de abril")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_deadlines, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inicializar vistas
        recyclerDeadlines = view.findViewById(R.id.recyclerDeadlines)

        recyclerDeadlines.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = DeadlinesAdapter(mockItems)
        }
    }
}
