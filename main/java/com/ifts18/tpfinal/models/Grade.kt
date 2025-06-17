package com.ifts18.tpfinal.models

data class Grade(
    val id: Int,
    val title: String,
    val value: Int,
    val status: GradeStatus,
    val subjectId: Int,
    val date: String? = null
)

