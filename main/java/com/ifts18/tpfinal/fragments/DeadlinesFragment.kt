package com.ifts18.tpfinal.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ifts18.tpfinal.adapters.DeadlinesAdapter
import com.ifts18.tpfinal.databinding.FragmentDeadlinesBinding
import com.ifts18.tpfinal.models.DeadlineItem

class DeadlinesFragment : Fragment() {

    private var _binding: FragmentDeadlinesBinding? = null
    private val binding get() = _binding!!

    private val mockItems = listOf(
        DeadlineItem("Trabajo Práctico 2", "14 de marzo"),
        DeadlineItem("Parcial 1", "30 de marzo"),
        DeadlineItem("Trabajo Práctico 3", "7 de abril")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDeadlinesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.recyclerDeadlines.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = DeadlinesAdapter(mockItems)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
