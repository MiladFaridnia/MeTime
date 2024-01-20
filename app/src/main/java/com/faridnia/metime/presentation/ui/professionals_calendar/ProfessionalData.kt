package com.faridnia.metime.presentation.ui.professionals_calendar

import com.faridnia.metime.util.getCurrentDateTime
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

fun getSampleAvailableHours(): List<AvailableHour> {
    val availableHours = mutableListOf<AvailableHour>()
    for (i in 1..10) {
        availableHours.add(
            AvailableHour(
                date = getCurrentDateTime(),
            )
        )
    }
    return availableHours
}

fun getSampleAvailableDays(): List<AvailableDay> {
    val availableDays = mutableListOf<AvailableDay>()
    for (i in 1..10) {
        availableDays.add(
            AvailableDay(
                date = getCurrentDateTime(),
                availableHours = getSampleAvailableHours()
            )
        )
    }
    return availableDays
}

fun getSampleProfessionalData() = ProfessionalData(
    name = "Anna Smith",
    jobTitle = "Nailist",
    rate = 5.0f,
    availableDays = getSampleAvailableDays()
)