package com.faridnia.metime.presentation.ui.login_bottom_sheet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
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
import com.faridnia.metime.presentation.ui.theme.MeTimeTheme
import com.faridnia.booking_domain.presentation.LightAndDarkPreview

@com.faridnia.booking_domain.presentation.LightAndDarkPreview
@Composable
fun PreviewLoginBottomSheetScreen() {
    MeTimeTheme {
        LoginBottomSheetScreen(
            state = remember { mutableStateOf(LoginBottomSheetState()) },
            navController = rememberNavController()
        )
    }
}

@Composable
fun LoginBottomSheetScreen(
    state: State<LoginBottomSheetState>,
    navController: NavController
) {

    Column(
        horizontalAlignment = CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
            .padding(start = 24.dp, end = 24.dp),
    ) {
        Spacer(modifier = Modifier.height(70.dp))

        Text(
            text = "Hey there!",
            style = TextStyle(
                fontSize = 32.sp,
                lineHeight = 41.6.sp,
                fontFamily = FontFamily(Font(R.font.raleway_light)),
                fontWeight = FontWeight(700),
                color = MaterialTheme.colorScheme.onSurface,
            )
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Before schedule, please enter your account or create one!",
            style = TextStyle(
                fontSize = 18.sp,
                lineHeight = 21.76.sp,
                fontFamily = FontFamily(Font(R.font.raleway_light)),
                fontWeight = FontWeight(500),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center,
            )
        )

        Spacer(modifier = Modifier.weight(1.0f))

        Column(horizontalAlignment = CenterHorizontally) {

            com.faridnia.metime.onboarding_presentation.presentaition.component.PrimaryButton(
                modifier = Modifier.fillMaxWidth(),
                buttonText = "Log In",
                isEnabled = true,
                isLoading = state.value.isLoading
            ) {
            }

            com.faridnia.metime.onboarding_presentation.presentaition.component.SecondaryButton(
                modifier = Modifier,
                buttonText = "Skip",
                isEnabled = true,
                isLoading = false
            ) {
            }

        }

        Spacer(modifier = Modifier.height(40.dp))

    }
}