package com.ifts18.tpfinal.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ifts18.tpfinal.R
import com.ifts18.tpfinal.models.Grade
import com.ifts18.tpfinal.models.GradeStatus

class GradesAdapter(private val grades: List<Grade>) :
    RecyclerView.Adapter<GradesAdapter.GradesViewHolder>() {

    inner class GradesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val tvGradeTitle: TextView = itemView.findViewById(R.id.tvGradeTitle)
        private val tvGradeValue: TextView = itemView.findViewById(R.id.tvGradeValue)
        private val viewStatusIndicator: View = itemView.findViewById(R.id.viewStatusIndicator)
        private val ivStatusIcon: ImageView = itemView.findViewById(R.id.ivStatusIcon)

        fun bind(grade: Grade) {
            tvGradeTitle.text = grade.title
            tvGradeValue.text = "Nota: ${grade.value}"

            // Estado visual según GradeStatus
            when (grade.status) {
                GradeStatus.PROMOCIONADO -> {
                    viewStatusIndicator.setBackgroundColor(0xFF4CAF50.toInt()) // Verde
                    ivStatusIcon.setImageResource(R.drawable.ic_check_circle_24)
                }
                GradeStatus.ZONA_PROMOCION -> {
                    viewStatusIndicator.setBackgroundColor(0xFFFFC107.toInt()) // Amarillo
                    ivStatusIcon.setImageResource(R.drawable.ic_warning_24)
                }
                GradeStatus.REGULAR -> {
                    viewStatusIndicator.setBackgroundColor(0xFFFF9800.toInt()) // Naranja
                    ivStatusIcon.setImageResource(R.drawable.ic_info_24)
                }
                GradeStatus.LIBRE -> {
                    viewStatusIndicator.setBackgroundColor(0xFFF44336.toInt()) // Rojo
                    ivStatusIcon.setImageResource(R.drawable.ic_block_24)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GradesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_grade, parent, false)
        return GradesViewHolder(view)
    }

    override fun onBindViewHolder(holder: GradesViewHolder, position: Int) {
        holder.bind(grades[position])
    }

    override fun getItemCount(): Int = grades.size
}