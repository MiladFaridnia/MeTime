package com.faridnia.metime.onboarding_presentation.presentaition.choose_expert

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.faridnia.core.R
import com.faridnia.metime.Screen
import com.faridnia.metime.core.util.UiEvent
import com.faridnia.metime.core.data.model.getSampleExperts
import com.faridnia.metime.presentation.LightAndDarkPreview
import com.faridnia.metime.presentation.component.ExpertItem
import com.faridnia.metime.presentation.component.PagerIndicator
import com.faridnia.metime.presentation.component.SecondaryButton

@LightAndDarkPreview
@Composable
fun PreviewChooseExpertScreen() {
    ChooseExpertScreen(
        state = remember { mutableStateOf(ChooseExpertState()) },
        onEvent = {},
        onNavigate = {}
    )
}

@Composable
fun ChooseExpertScreen(
    state: State<ChooseExpertState>,
    onEvent: (ChooseExpertEvent) -> Unit,
    onNavigate: (UiEvent.Navigate) -> Unit
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
            text = "MeTime", style = TextStyle(
                fontSize = 19.sp,
                fontFamily = FontFamily(Font(R.font.raleway_light)),
                fontWeight = FontWeight(700),
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center,
            )
        )

        Spacer(modifier = Modifier.height(50.dp))

        PagerIndicator(
            selectedPageIndex = 2
        )

        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text = "Now, choose one that fit your needs:",
            style = TextStyle(
                fontSize = 24.sp,
                lineHeight = 32.72.sp,
                fontFamily = FontFamily(Font(R.font.raleway_light)),
                fontWeight = FontWeight(600),
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center,
            )
        )

        Spacer(modifier = Modifier.height(40.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.padding(16.dp)
        ) {
            items(items = getSampleExperts(), key = { it.id }) {
                ExpertItem(it) {
                    onNavigate(UiEvent.Navigate(Screen.ProfessionalsCalendarScreen.route))
                }
            }
        }

        Spacer(modifier = Modifier.weight(1.0f))

        SecondaryButton(
            modifier = Modifier.fillMaxWidth(),
            buttonText = "I don‘t have a preference",
            isEnabled = true,
            isLoading = false
        ) {

        }

        Spacer(modifier = Modifier.height(40.dp))
    }
}




