package com.faridnia.metime.presentation.ui.professionals_calendar

import java.util.Date

data class ProfessionalData(
    val name: String,
    val jobTitle: String,
    val rate: Float,
    val availableDays: List<AvailableDay>
)

data class AvailableDay(
    val date: Date,
    val availableHours: List<AvailableHour>
)

data class AvailableHour(
    val date: Date
)