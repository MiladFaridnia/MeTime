package com.faridnia.metime.data


import com.faridnia.metime.getCurrentDateTime
import java.util.Date
import java.util.UUID

data class SuccessfulBookingData(
    val id : String = UUID.randomUUID().toString(),
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