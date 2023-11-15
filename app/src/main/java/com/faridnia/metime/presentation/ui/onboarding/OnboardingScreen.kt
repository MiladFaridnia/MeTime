package com.faridnia.metime.presentation.ui.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.faridnia.metime.util.LightAndDarkPreview

@LightAndDarkPreview
@Composable
fun PreviewOnboardingScreen() {
    OnboardingScreen(
        state = remember { mutableStateOf(OnboardingState()) },
        onEvent = {},
        navController = rememberNavController()
    )
}

@Composable
fun OnboardingScreen(
    state: State<OnboardingState>,
    onEvent: (OnboardingEvent) -> Unit,
    navController: NavController
) {

    Column(
        horizontalAlignment = CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
            .padding(start = 24.dp, end = 24.dp),
    ) {
        Spacer(modifier = Modifier.height(40.dp))



    }
}

