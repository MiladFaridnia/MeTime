package com.faridnia.metime.presentation.ui.professionals_calendar

data class ProsCalState(
    val isLoading: Boolean = false,
    val error: String = "",
    val professionalData : ProfessionalData
)
