package com.faridnia.booking_presentation.professionals_calendar

import com.faridnia.metime.data.ProfessionalData

data class ProsCalState(
    val isLoading: Boolean = false,
    val error: String = "",
    val professionalData : ProfessionalData
)
