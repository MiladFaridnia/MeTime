package com.faridnia.metime.presentation.ui.choose_service_type

import com.faridnia.metime.R
import com.faridnia.metime.presentation.ui.choose_service.Service

data class ServiceType(
    val photoResourceId: Int,
    val title: String,
    val price: Long,
    val service: Service
) //FIXME resource Id must be changed to url

fun getSampleServiceTypes() = listOf(
    ServiceType(
        photoResourceId = R.drawable.manicure,
        title = "Basic Manicure",
        price = 5,
        service = Service(
            R.drawable.nail, "Nail"
        )

    ),
    ServiceType(
        photoResourceId = R.drawable.nail_1,
        title = "Basic Pedicure",
        price = 50,
        service = Service(
            R.drawable.nail, "Nail"
        )
    ),
    ServiceType(
        photoResourceId = R.drawable.gel_pedicure,
        title = "Gel Manicure",
        price = 25,
        service = Service(
            R.drawable.nail, "Nail"
        )
    ),
    ServiceType(
        photoResourceId = R.drawable.gel_pedicure,
        title = "Gel Manicure",
        price = 15,
        service = Service(
            R.drawable.nail, "Nail"
        )
    ),
    ServiceType(
        photoResourceId = R.drawable.acrylic_extention,
        title = "Acrylic Extensions",
        price = 35,
        service = Service(
            R.drawable.nail, "Nail"
        )
    )
)