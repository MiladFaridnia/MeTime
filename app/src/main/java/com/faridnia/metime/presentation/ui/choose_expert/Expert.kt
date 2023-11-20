package com.faridnia.metime.presentation.ui.choose_expert

data class Expert(
    val photoResourceId: Int,
    val name: String,
    val description: String,
    val rate : Double
) //FIXME resource Id must be changed to url
