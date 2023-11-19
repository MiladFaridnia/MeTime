package com.faridnia.metime.presentation.nav_graph

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.faridnia.metime.presentation.ui.choose_expert.ChooseExpertScreen
import com.faridnia.metime.presentation.ui.choose_expert.ChooseExpertState
import com.faridnia.metime.presentation.ui.choose_service.ChooseServiceScreen
import com.faridnia.metime.presentation.ui.choose_service.ChooseServiceState
import com.faridnia.metime.presentation.ui.choose_service_type.ChooseServiceTypeScreen
import com.faridnia.metime.presentation.ui.choose_service_type.ChooseServiceTypeState
import com.faridnia.metime.presentation.ui.login_bottom_sheet.LoginBottomSheetScreen
import com.faridnia.metime.presentation.ui.login_bottom_sheet.LoginBottomSheetState
import com.faridnia.metime.presentation.ui.onboarding.OnboardingScreen
import com.faridnia.metime.presentation.ui.onboarding.OnboardingState

fun NavGraphBuilder.onboardingNavGraph(
    navController: NavHostController,
    onNavigate: (ActionBarTitle?, HideBackButton) -> Unit,
) {
    navigation(startDestination = Screen.OnboardingScreen.route, route = ONBOARDING_ROUTE) {

        composable(route = Screen.OnboardingScreen.route) {
            val state = remember { mutableStateOf(OnboardingState()) }
            OnboardingScreen(state = state, onEvent = {}, navController = navController)
        }

        composable(route = Screen.ChooseServiceScreen.route) {
            val state = remember { mutableStateOf(ChooseServiceState()) }
            ChooseServiceScreen(state = state, onEvent = {}, navController = navController)
        }

        composable(route = Screen.ChooseServiceTypeScreen.route) {
            val state = remember { mutableStateOf(ChooseServiceTypeState()) }
            ChooseServiceTypeScreen(state = state, onEvent = {}, navController = navController)
        }

        composable(route = Screen.ChooseExpertScreen.route) {
            val state = remember { mutableStateOf(ChooseExpertState()) }
            ChooseExpertScreen(state = state, onEvent = {}, navController = navController)
        }

        composable(route = Screen.LoginBottomSheetScreen.route) {
            val state = remember { mutableStateOf(LoginBottomSheetState()) }
            LoginBottomSheetScreen(state = state, navController = navController)
        }

    }
}