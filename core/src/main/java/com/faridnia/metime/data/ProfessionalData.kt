package com.faridnia.metime.data

import com.faridnia.metime.getCurrentDateTime
import java.util.Date
import java.util.UUID

data class ProfessionalData(
    val id : String = UUID.randomUUID().toString(),
    val name: String,
    val jobTitle: String,
    val rate: Float,
    val availableDays: List<AvailableDay>
)

data class AvailableDay(
    val id : String = UUID.randomUUID().toString(),
    val date: Date,
    val availableHours: List<AvailableHour>
)

data class AvailableHour(
    val id : String = UUID.randomUUID().toString(),
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