package com.faridnia.metime.presentation.ui.choose_service

import com.faridnia.metime.R

data class Service(val photoResourceId: Int, val title: String)

fun getSampleServices() = listOf(
    Service(R.drawable.nail, "Nail"),
    Service(R.drawable.eyebrowns, "Eyebrows"),
    Service(R.drawable.massage, "Massage"),
    Service(R.drawable.hair, "Hair"),
)