package com.faridnia.metime.presentation.nav_graph

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.faridnia.metime.ONBOARDING_ROUTE
import com.faridnia.metime.Screen
import com.faridnia.metime.navigation.navigate
import com.faridnia.metime.onboarding_presentation.presentaition.choose_expert.ChooseExpertScreen
import com.faridnia.metime.onboarding_presentation.presentaition.choose_expert.ChooseExpertState
import com.faridnia.metime.onboarding_presentation.presentaition.choose_service.ChooseServiceScreen
import com.faridnia.metime.onboarding_presentation.presentaition.choose_service.ChooseServiceState
import com.faridnia.metime.onboarding_presentation.presentaition.choose_service_type.ChooseServiceTypeScreen
import com.faridnia.metime.onboarding_presentation.presentaition.choose_service_type.ChooseServiceTypeState
import com.faridnia.metime.onboarding_presentation.presentaition.component.onboarding.OnboardingState
import com.faridnia.metime.onboarding_presentation.presentaition.login_bottom_sheet.LoginBottomSheetScreen
import com.faridnia.metime.onboarding_presentation.presentaition.login_bottom_sheet.LoginBottomSheetState
import com.faridnia.metime.onboarding_presentation.presentaition.onboarding.OnboardingScreen
import com.faridnia.metime.util.FirebaseUtils
import com.google.firebase.analytics.FirebaseAnalytics

fun NavGraphBuilder.onboardingNavGraph(
    firebaseAnalytics: FirebaseAnalytics,
    navController: NavHostController,
    onNavigate: (ActionBarTitle?, HideBackButton) -> Unit,
) {
    navigation(startDestination = Screen.OnboardingScreen.route, route = ONBOARDING_ROUTE) {

        composable(route = Screen.OnboardingScreen.route) {

            FirebaseUtils().logScreenView(firebaseAnalytics, Screen.OnboardingScreen.route)

            val state = remember { mutableStateOf(OnboardingState()) }
            OnboardingScreen(
                state = state,
                onEvent = {},
                onNavigate = navController::navigate
            )
        }

        composable(route = Screen.ChooseServiceScreen.route) {

            FirebaseUtils().logScreenView(firebaseAnalytics, Screen.ChooseServiceScreen.route)


            val state = remember { mutableStateOf(ChooseServiceState()) }
            ChooseServiceScreen(
                state = state,
                onEvent = {},
                onNavigate = navController::navigate
            )
        }

        composable(route = Screen.ChooseServiceTypeScreen.route) {

            FirebaseUtils().logScreenView(firebaseAnalytics, Screen.ChooseServiceTypeScreen.route)

            val state =
                remember { mutableStateOf(ChooseServiceTypeState()) }
            ChooseServiceTypeScreen(
                state = state,
                onEvent = {},
                onNavigate = navController::navigate
            )
        }

        composable(route = Screen.ChooseExpertScreen.route) {

            FirebaseUtils().logScreenView(firebaseAnalytics, Screen.ChooseExpertScreen.route)

            val state =
                remember { mutableStateOf(ChooseExpertState()) }
            ChooseExpertScreen(
                state = state,
                onEvent = {},
                onNavigate = navController::navigate
            )
        }

        composable(route = Screen.LoginBottomSheetScreen.route) {

            FirebaseUtils().logScreenView(firebaseAnalytics, Screen.LoginBottomSheetScreen.route)

            val state = remember { mutableStateOf(LoginBottomSheetState()) }
            LoginBottomSheetScreen(state = state, navController = navController)
        }

    }
}
