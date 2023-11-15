package com.faridnia.metime.presentation.nav_graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.onboardingNavGraph(
    navController: NavHostController,
    onNavigate: (ActionBarTitle?, HideBackButton) -> Unit,
) {
    navigation(startDestination = Screen.OnboardingScreen.route, route = ONBOARDING_ROUTE) {

        composable(route = Screen.OnboardingScreen.route) {

        }

    }
}