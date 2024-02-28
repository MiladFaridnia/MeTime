package com.faridnia.booking_presentation.successful_booking

import com.faridnia.metime.core.data.model.SuccessfulBookingData

class SuccessfulBookingState(
    val isLoading: Boolean = false,
    val error: String = "",
    val successfulBookingData: List<SuccessfulBookingData> = emptyList()
)
