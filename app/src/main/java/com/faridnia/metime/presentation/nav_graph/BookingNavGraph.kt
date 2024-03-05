package com.faridnia.metime.presentation.nav_graph

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.faridnia.booking_presentation.professionals_calendar.ProsCalState
import com.faridnia.booking_presentation.professionals_calendar.ProsCalendarScreen
import com.faridnia.metime.BOOKING_ROUTE
import com.faridnia.metime.Screen
import com.faridnia.metime.core.data.model.getSampleProfessionalData
import com.faridnia.metime.getCurrentMonthName
import com.faridnia.metime.navigation.navigate

fun NavGraphBuilder.bookingNavGraph(
    navController: NavHostController,
    onNavigate: (ActionBarTitle?, HideBackButton) -> Unit,
) {
    navigation(startDestination = Screen.ProfessionalsCalendarScreen.route, route = BOOKING_ROUTE) {

        composable(route = Screen.ProfessionalsCalendarScreen.route) {
            val state =
                remember {
                    mutableStateOf(
                        ProsCalState(
                            selectedMonth = getCurrentMonthName(),
                            professionalData = getSampleProfessionalData()
                        )
                    )
                }
            ProsCalendarScreen(
                state = state,
                onEvent = {},
                onNavigate = navController::navigate
            )
        }
        /*
                composable(route = Screen.LoginBottomSheetScreen.route) {
                    val state = remember { mutableStateOf(LoginBottomSheetState()) }
                    LoginBottomSheetScreen(state = state, navController = navController)
                }*/

    }
}