package com.faridnia.metime.data

import com.faridnia.core.R
import java.util.UUID

data class Expert(
    val id: String = UUID.randomUUID().toString(),
    val photoResourceId: Int,
    val name: String,
    val description: String,
    val rate: Double
) //FIXME resource Id must be changed to url

fun getSampleExperts() = listOf(
    Expert(
        photoResourceId = R.drawable.manicure,
        name = "Anna Smith",
        description = "Nail designer",
        rate = 4.8
    ),
    Expert(
        photoResourceId = R.drawable.nail_1,
        name = "Mrs Appleberry",
        description = "Nail painter",
        rate = 4.6
    ),
    Expert(
        photoResourceId = R.drawable.gel_pedicure,
        name = "Sara Jordan",
        description = "Nail designer, painter",
        rate = 4.5
    ),
    Expert(
        photoResourceId = R.drawable.gel_pedicure,
        name = "Beth Jess",
        description = "Nail designer, Manicure expert",
        rate = 4.2
    ),
    Expert(
        photoResourceId = R.drawable.acrylic_extention,
        name = "Mary Oven",
        description = "Nail Designer",
        rate = 4.2
    )
)
