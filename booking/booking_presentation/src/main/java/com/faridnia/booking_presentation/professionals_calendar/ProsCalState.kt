package com.faridnia.booking_presentation.professionals_calendar

import com.faridnia.metime.core.data.model.ProfessionalData

data class ProsCalState(
    val isLoading: Boolean = false,
    val error: String = "",
    val professionalData : ProfessionalData
)
