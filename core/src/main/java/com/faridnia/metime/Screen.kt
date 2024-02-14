package com.faridnia.metime


const val ONBOARDING_ROUTE = "onboarding_route"

sealed class Screen(val route: String, val title: String?) {

    object OnboardingScreen : Screen(route = "onboarding_screen", title = "onboarding")
    object ChooseExpertScreen : Screen(route = "choose_expert_screen", title = "Choose Expert")
    object ChooseServiceScreen : Screen(route = "choose_service_screen", title = "Choose Service")
    object ChooseServiceTypeScreen : Screen(route = "choose_service_type_screen", title = "Choose Service Type")
    object LoginBottomSheetScreen : Screen(route = "login_bottom_sheet_screen", title = "Login BottomSheet")
    object ProfessionalsCalendarScreen : Screen(route = "professionals_calendar_screen", title = "Login BottomSheet")

}
