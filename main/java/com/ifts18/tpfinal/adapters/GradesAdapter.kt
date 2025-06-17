package com.ifts18.tpfinal.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ifts18.tpfinal.databinding.ItemGradeBinding
import com.ifts18.tpfinal.models.Grade
import com.ifts18.tpfinal.models.GradeStatus
import com.ifts18.tpfinal.R


class GradesAdapter(private val grades: List<Grade>) :
    RecyclerView.Adapter<GradesAdapter.GradesViewHolder>() {

    inner class GradesViewHolder(private val binding: ItemGradeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(grade: Grade) {
            binding.tvGradeTitle.text = grade.title
            binding.tvGradeValue.text = "Nota: ${grade.value}"

            // Estado visual segun GradeStatus
            when (grade.status) {
                GradeStatus.PROMOCIONADO -> {
                    binding.viewStatusIndicator.setBackgroundColor(0xFF4CAF50.toInt()) // Verde
                    binding.ivStatusIcon.setImageResource(R.drawable.ic_check_circle_24)
                }
                GradeStatus.ZONA_PROMOCION -> {
                    binding.viewStatusIndicator.setBackgroundColor(0xFFFFC107.toInt()) // Amarillo
                    binding.ivStatusIcon.setImageResource(R.drawable.ic_warning_24)
                }
                GradeStatus.REGULAR -> {
                    binding.viewStatusIndicator.setBackgroundColor(0xFFFF9800.toInt()) // Naranja
                    binding.ivStatusIcon.setImageResource(R.drawable.ic_info_24)
                }
                GradeStatus.LIBRE -> {
                    binding.viewStatusIndicator.setBackgroundColor(0xFFF44336.toInt()) // Rojo
                    binding.ivStatusIcon.setImageResource(R.drawable.ic_block_24)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GradesViewHolder {
        val binding = ItemGradeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GradesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GradesViewHolder, position: Int) {
        holder.bind(grades[position])
    }

    override fun getItemCount(): Int = grades.size
}
