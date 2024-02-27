package com.faridnia.metime


const val ONBOARDING_ROUTE = "onboarding_route"
const val BOOKING_ROUTE = "booking_route"

sealed class Screen(val route: String, val title: String?) {

    data object OnboardingScreen : Screen(route = "onboarding_screen", title = "Onboarding")
    data object ChooseExpertScreen : Screen(route = "choose_expert_screen", title = "Choose Expert")
    data object ChooseServiceScreen : Screen(route = "choose_service_screen", title = "Choose Service")
    data object ChooseServiceTypeScreen : Screen(route = "choose_service_type_screen", title = "Choose Service Type")
    data object LoginBottomSheetScreen : Screen(route = "login_bottom_sheet_screen", title = "Login BottomSheet")
    data object ProfessionalsCalendarScreen : Screen(route = "professionals_calendar_screen", title = "Professionals Calendar")

}
