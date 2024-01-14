package com.faridnia.metime.presentation.ui.successful_booking

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.faridnia.metime.R
import com.faridnia.metime.presentation.component.PrimaryButton
import com.faridnia.metime.presentation.component.SecondaryButton
import com.faridnia.metime.presentation.ui.theme.MeTimeTheme
import com.faridnia.metime.util.LightAndDarkPreview


@LightAndDarkPreview
@Composable
fun PreviewSuccessfulBookingScreen() {
    MeTimeTheme {
        SuccessfulBookingScreen(
//            state = remember { mutableStateOf(State()) },
//            onEvent = {},
            navController = rememberNavController()
        )
    }
}

@Composable
fun SuccessfulBookingScreen(
//    state: State<ChooseServiceState>,
//    onEvent: (ChooseServiceEvent) -> Unit,
    navController: NavController
) {

    Column(
        horizontalAlignment = CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
            .padding(
                start = 24.dp, end = 24.dp
            ),
    ) {

        Image(
            painter = painterResource(id = R.drawable.heart),
            contentDescription = "image description",
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(72.dp))

        val annotatedString = getThankForBookingStringStyle()

        Text(
            text = annotatedString,
            style = TextStyle(
                lineHeight = 38.sp,
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center,
            )
        )

        Spacer(modifier = Modifier.height(72.dp))

        Column(
            modifier = Modifier
                .border(
                    width = 0.5.dp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    shape = RoundedCornerShape(size = 10.dp)
                )
                .padding(16.dp),
            horizontalAlignment = CenterHorizontally

        ) {

            Text(
                text = "Your booking details: ",
                style = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 25.sp,
                    fontFamily = FontFamily(Font(R.font.raleway_light)),
                    fontWeight = FontWeight(500),
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Tuesday, 19    04:30pm",
                style = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 25.sp,
                    fontFamily = FontFamily(Font(R.font.raleway_light)),
                    fontWeight = FontWeight(500),
                    color = MaterialTheme.colorScheme.onSurface
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "At The Gallery Salon",
                style = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 25.sp,
                    fontFamily = FontFamily(Font(R.font.raleway_light)),
                    fontWeight = FontWeight(500),
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "8502 Preston Rd. Inglewood",
                style = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 25.sp,
                    fontFamily = FontFamily(Font(R.font.raleway_light)),
                    fontWeight = FontWeight(600),
                    color = MaterialTheme.colorScheme.onSurface,
                    textDecoration = TextDecoration.Underline
                )
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        PrimaryButton(
            modifier = Modifier.fillMaxWidth(),
            buttonText = "Keep booking",
            isEnabled = true,
            isLoading = false,
            onClick = {}
        )

        Spacer(modifier = Modifier.height(16.dp))

        SecondaryButton(
            modifier = Modifier.fillMaxWidth(),
            buttonText = "Main Page",
            isEnabled = true,
            isLoading = false,
            onClick = {}

        )

        Spacer(modifier = Modifier.height(40.dp))

    }

}

@Composable
private fun getThankForBookingStringStyle(): AnnotatedString {
    val annotatedString = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                fontSize = 24.sp,
                fontFamily = FontFamily(Font(R.font.raleway_light)),
                fontWeight = FontWeight(500),
                color = MaterialTheme.colorScheme.onSurface,
            )
        ) {
            append("Thank you for booking with\n")
        }
        withStyle(
            style = SpanStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily(Font(R.font.raleway_light)),
                color = MaterialTheme.colorScheme.onSurface,
            )
        ) {
            append("MeTime")
        }
    }
    return annotatedString
}

