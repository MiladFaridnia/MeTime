package com.faridnia.metime.presentation.ui.professionals_calendar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
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
import com.faridnia.metime.presentation.LightAndDarkPreview
import com.faridnia.metime.presentation.component.DaysInMonthComponent
import com.faridnia.metime.presentation.component.HoursInDayComponent
import com.faridnia.metime.presentation.component.PrimaryButton
import com.faridnia.metime.presentation.component.ProfileComponent
import com.faridnia.metime.presentation.nav_graph.Screen
import com.faridnia.metime.presentation.ui.theme.MeTimeTheme

@LightAndDarkPreview
@Composable
fun PreviewProsCalendarScreen() {
    MeTimeTheme {
        ProsCalendarScreen(
            state = remember {
                mutableStateOf(
                    ProsCalState(
                        professionalData = getSampleProfessionalData()
                    )
                )
            }, navController = rememberNavController()
        )
    }
}

@Composable
fun ProsCalendarScreen(
    state: State<ProsCalState>, navController: NavController
) {

    Column(
        horizontalAlignment = CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
            .padding(start = 24.dp, end = 24.dp),
    ) {

        Spacer(modifier = Modifier.height(70.dp))

        ProfileComponent(state)

        Spacer(modifier = Modifier.height(50.dp))

        Divider(
            modifier = Modifier
                .padding(0.dp)
                .width(375.dp)
                .height(1.dp)
                .background(color = MaterialTheme.colorScheme.onSurfaceVariant)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Select date & time ", style = TextStyle(
                fontSize = 24.sp,
                lineHeight = 32.72.sp,
                fontFamily = FontFamily(Font(R.font.raleway_light)),
                fontWeight = FontWeight(600),
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center,
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        DaysInMonthComponent(
            state.value.professionalData.availableDays
        )

        Spacer(modifier = Modifier.height(24.dp))

        HoursInDayComponent(
            state.value.professionalData.availableDays.first().availableHours
        )

        Spacer(modifier = Modifier.weight(1.0f))

        PrimaryButton(
            modifier = Modifier.fillMaxWidth(),
            buttonText = "Book",
            isEnabled = true,
            isLoading = false
        ) {
            navController.navigate(Screen.ChooseServiceScreen.route)
        }

        Spacer(modifier = Modifier.height(40.dp))

    }
}
