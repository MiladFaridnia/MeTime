package com.faridnia.metime.presentation.ui.successful_booking

import com.faridnia.metime.presentation.ui.choose_service.Service
import com.faridnia.metime.presentation.ui.professionals_calendar.ProfessionalData
import java.util.Date

data class SuccessfulBookingData(
    val salonName: String,
    val address: String,
    val bookDate: Date,
    val professionalData : ProfessionalData,
    val serviceList : List<Service>,
    val price : Int
)