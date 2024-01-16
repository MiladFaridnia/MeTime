package com.faridnia.metime.presentation.ui.successful_booking

class SuccessfulBookingState(
    val isLoading: Boolean = false,
    val error: String = "",
    val successfulBookingData: List<SuccessfulBookingData> = emptyList()
)
