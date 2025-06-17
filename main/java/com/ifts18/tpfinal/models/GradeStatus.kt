package com.ifts18.tpfinal.models

import com.ifts18.tpfinal.R

enum class GradeStatus(val displayName: String, val colorRes: Int) {
    PROMOCIONADO("Promocionado", R.color.grade_high),
    ZONA_PROMOCION("Zona de promoción", R.color.grade_medium),
    REGULAR("Regular", R.color.grade_medium),
    LIBRE("Libre", R.color.grade_low)
}