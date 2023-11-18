package com.faridnia.metime.presentation.nav_graph


const val ONBOARDING_ROUTE = "onboarding_route"

sealed class Screen(val route: String, val title: String?) {

    object OnboardingScreen : Screen(route = "onboarding_screen", title = "onboarding")

}
