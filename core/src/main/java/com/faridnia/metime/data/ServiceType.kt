package com.faridnia.metime.data

import com.faridnia.core.R
import java.util.UUID

data class ServiceType(
    val id: String = UUID.randomUUID().toString(),
    val photoResourceId: Int,
    val title: String,
    val price: Long,
    val service: Service,
) //FIXME resource Id must be changed to url

fun getSampleServiceTypes() = listOf(
    ServiceType(
        photoResourceId = R.drawable.manicure,
        title = "Basic Manicure",
        price = 5,
        service = Service(
            photoResourceId = R.drawable.nail, title = "Nail"
        )

    ),
    ServiceType(
        photoResourceId = R.drawable.nail_1,
        title = "Basic Pedicure",
        price = 50,
        service = Service(
            photoResourceId = R.drawable.nail, title = "Nail"
        )
    ),
    ServiceType(
        photoResourceId = R.drawable.gel_pedicure,
        title = "Gel Manicure",
        price = 25,
        service = Service(
            photoResourceId = R.drawable.nail, title = "Nail"
        )
    ),
    ServiceType(
        photoResourceId = R.drawable.gel_pedicure,
        title = "Gel Manicure",
        price = 15,
        service = Service(
            photoResourceId = R.drawable.nail, title = "Nail"
        )
    ),
    ServiceType(
        photoResourceId = R.drawable.acrylic_extention,
        title = "Acrylic Extensions",
        price = 35,
        service = Service(
            photoResourceId = R.drawable.nail, title = "Nail"
        )
    )
)