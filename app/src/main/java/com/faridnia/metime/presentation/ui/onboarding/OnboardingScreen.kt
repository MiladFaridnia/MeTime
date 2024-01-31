package com.faridnia.metime.presentation.ui.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.faridnia.metime.R
import com.faridnia.metime.onboarding_presentation.presentaition.component.PrimaryButton
import com.faridnia.metime.onboarding_presentation.presentaition.component.SecondaryButton
import com.faridnia.metime.presentation.nav_graph.Screen
import com.faridnia.metime.presentation.ui.theme.MeTimeTheme
import com.faridnia.booking_domain.presentation.LightAndDarkPreview

@com.faridnia.booking_domain.presentation.LightAndDarkPreview
@Composable
fun PreviewOnboardingScreen() {
    MeTimeTheme {
        OnboardingScreen(
            state = remember { mutableStateOf(OnboardingState()) },
            onEvent = {},
            navController = rememberNavController()
        )
    }
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
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "MeTime",
            style = TextStyle(
                fontSize = 19.sp,
                fontFamily = FontFamily(Font(R.font.raleway_light)),
                fontWeight = FontWeight(700),
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center,
            )
        )

        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(385.dp),
            painter = painterResource(id = R.drawable.onboarding),
            contentDescription = "image description",
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(35.dp))

        Text(
            text = "Welcome to \nThe Gallery Salon!",
            style = TextStyle(
                fontSize = 32.sp,
                fontFamily = FontFamily(Font(R.font.raleway_light)),
                fontWeight = FontWeight(700),
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center,
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Follow the steps to schedule your next appointment with us.",
            style = TextStyle(
                fontSize = 18.sp,
                lineHeight = 22.sp,
                fontFamily = FontFamily(Font(R.font.raleway_light)),
                fontWeight = FontWeight(500),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center,
            )
        )

        Spacer(modifier = Modifier.weight(1.0f))

        Row(
            horizontalArrangement = Arrangement.spacedBy(15.dp, Alignment.Start),
            verticalAlignment = Alignment.Top,
        ) {

            com.faridnia.metime.onboarding_presentation.presentaition.component.SecondaryButton(
                modifier = Modifier.weight(1.0f),
                buttonText = "Skip",
                isEnabled = true,
                isLoading = false
            ) {
            }

            com.faridnia.metime.onboarding_presentation.presentaition.component.PrimaryButton(
                modifier = Modifier.weight(1.0f),
                buttonText = "Start",
                isEnabled = true,
                isLoading = false
            ) {
                navController.navigate(Screen.ChooseServiceScreen.route)
            }
        }

        Spacer(modifier = Modifier.height(40.dp))

    }
}

