package com.faridnia.metime.presentation.ui.successful_booking

import com.faridnia.metime.presentation.ui.choose_service_type.ServiceType
import com.faridnia.metime.presentation.ui.choose_service_type.getSampleServiceTypes
import com.faridnia.metime.presentation.ui.professionals_calendar.ProfessionalData
import com.faridnia.metime.presentation.ui.professionals_calendar.getSampleProfessionalData
import com.faridnia.metime.util.getCurrentDateTime
import java.util.Date

data class SuccessfulBookingData(
    val salonName: String,
    val address: String,
    val bookDate: Date,
    val professionalData: ProfessionalData,
    val serviceTypeList: List<ServiceType>,
    val price: Int
)

fun getSampleSuccessfulBookingData(): List<SuccessfulBookingData> {
    val successfulBookingList = mutableListOf<SuccessfulBookingData>()

    for (i in 0..10) {
        successfulBookingList.add(
            SuccessfulBookingData(
                salonName = "Gallery",
                address = "Address",
                bookDate = getCurrentDateTime(),
                price = 33,
                professionalData = getSampleProfessionalData(),
                serviceTypeList = getSampleServiceTypes()
            )
        )
    }
    return successfulBookingList
}