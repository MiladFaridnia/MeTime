package com.faridnia.metime.data

import com.faridnia.core.R
import java.util.UUID

data class Service(
    val id: String = UUID.randomUUID().toString(),
    val photoResourceId: Int,
    val title: String,
)

fun getSampleServices() = listOf(
    Service(photoResourceId = R.drawable.nail, title = "Nail"),
    Service(photoResourceId = R.drawable.eyebrowns, title = "Eyebrows"),
    Service(photoResourceId = R.drawable.massage, title = "Massage"),
    Service(photoResourceId = R.drawable.hair, title = "Hair"),
)