package com.faridnia.metime.presentation.ui.professionals_calendar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.faridnia.metime.R
import com.faridnia.metime.presentation.ui.theme.MeTimeTheme
import com.faridnia.metime.util.LightAndDarkPreview

@LightAndDarkPreview
@Composable
fun PreviewLoginBottomSheetScreen() {
    MeTimeTheme {
        LoginBottomSheetScreen(
            state = remember { mutableStateOf(ProsCalState()) },
            navController = rememberNavController()
        )
    }
}

@Composable
fun LoginBottomSheetScreen(
    state: State<ProsCalState>,
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

        Image(
            modifier = Modifier
                .width(98.dp)
                .height(98.dp),
            painter = painterResource(id = R.drawable.pro_cal),
            contentDescription = "image description",
            contentScale = ContentScale.FillBounds
        )

    }
}