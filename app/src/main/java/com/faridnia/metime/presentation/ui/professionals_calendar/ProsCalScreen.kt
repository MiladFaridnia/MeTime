package com.faridnia.metime.presentation.ui.professionals_calendar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.faridnia.metime.presentation.ui.theme.MeTimeTheme
import com.faridnia.metime.util.LightAndDarkPreview
import com.faridnia.metime.util.getCurrentDateTime

@LightAndDarkPreview
@Composable
fun PreviewLoginBottomSheetScreen() {
    MeTimeTheme {
        LoginBottomSheetScreen(
            state = remember {
                mutableStateOf(
                    ProsCalState(
                        professionalData = ProfessionalData(
                            name = "Anna Smith",
                            jobTitle = "Nailist",
                            rate = 5.0f,
                            availableDays = listOf(
                                AvailableDay(
                                    date = getCurrentDateTime(),
                                    availableHours = listOf(
                                        AvailableHour(
                                            date = getCurrentDateTime(),
                                        )
                                    )
                                ),
                                AvailableDay(
                                    date = getCurrentDateTime(),
                                    availableHours = listOf(
                                        AvailableHour(
                                            date = getCurrentDateTime(),
                                        )
                                    )
                                ),
                                AvailableDay(
                                    date = getCurrentDateTime(),
                                    availableHours = listOf(
                                        AvailableHour(
                                            date = getCurrentDateTime(),
                                        )
                                    )
                                ),
                                AvailableDay(
                                    date = getCurrentDateTime(),
                                    availableHours = listOf(
                                        AvailableHour(
                                            date = getCurrentDateTime(),
                                        )
                                    )
                                )
                            )
                        )
                    )
                )
            },
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

        Text(
            text = state.value.professionalData.name,
            style = TextStyle(
                fontSize = 24.sp,
                fontFamily = FontFamily(Font(R.font.raleway_light)),
                fontWeight = FontWeight(600),
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center,
            )
        )

        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = "Nail Designer",
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.raleway_light)),
                fontWeight = FontWeight(500),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center,
            )
        )

        Row {
            Image(
                modifier = Modifier
                    .width(20.dp)
                    .height(20.dp),
                painter = painterResource(id = R.drawable.star),
                contentDescription = "star",
                contentScale = ContentScale.Fit
            )

            Text(
                text = "5.0",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.raleway_light)),
                    fontWeight = FontWeight(500),
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    textAlign = TextAlign.Center,
                )
            )
        }
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
            text = "Select date & time ",
            style = TextStyle(
                fontSize = 24.sp,
                lineHeight = 32.72.sp,
                fontFamily = FontFamily(Font(R.font.raleway_light)),
                fontWeight = FontWeight(600),
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center,
            )
        )

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row {
                Text(
                    text = "Day",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.raleway_light)),
                        fontWeight = FontWeight(600),
                        color = MaterialTheme.colorScheme.onSurface,
                        textAlign = TextAlign.Center,
                    )
                )

                Spacer(modifier = Modifier.weight(1.0f))

                Text(
                    text = "October",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.raleway_light)),
                        fontWeight = FontWeight(500),
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                )

                Image(
                    modifier = Modifier
                        .width(14.dp)
                        .height(14.dp),
                    painter = painterResource(id = R.drawable.forward),
                    contentDescription = "forward",
                    contentScale = ContentScale.Fit
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            LazyRow {
                items(state.value.professionalData.availableDays) {
                    DateItem()
                }
            }
        }
    }
}

@Composable
private fun DateItem() {
    Column(
        horizontalAlignment = CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                shape = RoundedCornerShape(size = 10.dp)
            )
            .width(63.dp)
            .height(72.dp)
    ) {
        Text(
            text = "20\nWed",
            style = TextStyle(
                fontSize = 20.sp,
                lineHeight = 28.18.sp,
                fontFamily = FontFamily(Font(R.font.raleway_light)),
                fontWeight = FontWeight(600),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center,
            )
        )
    }
}