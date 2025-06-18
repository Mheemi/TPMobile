package com.ifts18.tpfinal.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ifts18.tpfinal.R
import com.ifts18.tpfinal.models.AttendanceRecord

class AttendanceAdapter(private val records: List<AttendanceRecord>) :
    RecyclerView.Adapter<AttendanceAdapter.AttendanceViewHolder>() {

    inner class AttendanceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val tvDate: TextView = itemView.findViewById(R.id.tvDate)
        private val tvStatus: TextView = itemView.findViewById(R.id.tvStatus)

        fun bind(record: AttendanceRecord) {
            tvDate.text = record.date
            tvStatus.text = if (record.wasPresent) "Presente" else "Ausente"
            val color = if (record.wasPresent) 0xFF4CAF50.toInt() else 0xFFF44336.toInt()
            itemView.setBackgroundColor(color)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AttendanceViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_attendance, parent, false)
        return AttendanceViewHolder(view)
    }

    override fun onBindViewHolder(holder: AttendanceViewHolder, position: Int) {
        holder.bind(records[position])
    }

    override fun getItemCount(): Int = records.size
}
