package com.ifts18.tpfinal.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ifts18.tpfinal.databinding.ItemAttendanceBinding
import com.ifts18.tpfinal.models.AttendanceRecord

class AttendanceAdapter(private val records: List<AttendanceRecord>) :
    RecyclerView.Adapter<AttendanceAdapter.AttendanceViewHolder>() {

    inner class AttendanceViewHolder(private val binding: ItemAttendanceBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(record: AttendanceRecord) {
            binding.tvDate.text = record.date
            binding.tvStatus.text = if (record.wasPresent) "Presente" else "Ausente"
            val color = if (record.wasPresent) 0xFF4CAF50.toInt() else 0xFFF44336.toInt()
            binding.root.setBackgroundColor(color)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AttendanceViewHolder {
        val binding = ItemAttendanceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AttendanceViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AttendanceViewHolder, position: Int) {
        holder.bind(records[position])
    }

    override fun getItemCount(): Int = records.size
}
