package com.ifts18.tpfinal.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ifts18.tpfinal.adapters.AttendanceAdapter
import com.ifts18.tpfinal.databinding.FragmentAttendanceBinding
import com.ifts18.tpfinal.models.AttendanceRecord

class AttendanceFragment : Fragment() {

    private var _binding: FragmentAttendanceBinding? = null
    private val binding get() = _binding!!

    private lateinit var attendanceAdapter: AttendanceAdapter

    private val attendanceRecords = listOf(
        AttendanceRecord("03/06/2025", true),
        AttendanceRecord("04/06/2025", true),
        AttendanceRecord("05/06/2025", false),
        AttendanceRecord("06/06/2025", true),
        AttendanceRecord("07/06/2025", true),
        AttendanceRecord("10/06/2025", false),
        AttendanceRecord("11/06/2025", true)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAttendanceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupRecycler()
        setupStats()
    }

    private fun setupRecycler() {
        attendanceAdapter = AttendanceAdapter(attendanceRecords)
        binding.recyclerAttendance.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = attendanceAdapter
        }
    }

    private fun setupStats() {
        val total = attendanceRecords.size
        val present = attendanceRecords.count { it.wasPresent }
        val absent = total - present
        val percent = (present * 100) / total

        binding.tvPercentage.text = "$percent%"
        binding.tvDaysPresent.text = present.toString()
        binding.tvDaysAbsent.text = absent.toString()
        binding.progressPresent.layoutParams.width = (percent * 10)
        binding.progressAbsent.layoutParams.width = ((100 - percent) * 10)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
