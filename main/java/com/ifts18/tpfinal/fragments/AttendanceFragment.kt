package com.ifts18.tpfinal.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ifts18.tpfinal.R
import com.ifts18.tpfinal.adapters.AttendanceAdapter
import com.ifts18.tpfinal.models.AttendanceRecord

class AttendanceFragment : Fragment() {

    private lateinit var recyclerAttendance: RecyclerView
    private lateinit var tvPercentage: TextView
    private lateinit var tvDaysPresent: TextView
    private lateinit var tvDaysAbsent: TextView
    private lateinit var progressPresent: View
    private lateinit var progressAbsent: View

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
    ): View? {
        return inflater.inflate(R.layout.fragment_attendance, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inicializar vistas
        recyclerAttendance = view.findViewById(R.id.recyclerAttendance)
        tvPercentage = view.findViewById(R.id.tvPercentage)
        tvDaysPresent = view.findViewById(R.id.tvDaysPresent)
        tvDaysAbsent = view.findViewById(R.id.tvDaysAbsent)
        progressPresent = view.findViewById(R.id.progressPresent)
        progressAbsent = view.findViewById(R.id.progressAbsent)

        setupRecycler()
        setupStats()
    }

    private fun setupRecycler() {
        attendanceAdapter = AttendanceAdapter(attendanceRecords)
        recyclerAttendance.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = attendanceAdapter
        }
    }

    private fun setupStats() {
        val total = attendanceRecords.size
        val present = attendanceRecords.count { it.wasPresent }
        val absent = total - present
        val percent = (present * 100) / total

        tvPercentage.text = "$percent%"
        tvDaysPresent.text = present.toString()
        tvDaysAbsent.text = absent.toString()
        progressPresent.layoutParams.width = (percent * 10)
        progressAbsent.layoutParams.width = ((100 - percent) * 10)
    }
}
