package com.faridnia.metime.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.faridnia.core.R
import com.faridnia.metime.core.data.model.AvailableDay
import com.faridnia.metime.core.data.model.getSampleAvailableDays
import com.faridnia.metime.formatDateToDayAndDayOfWeekInTwoLines
import com.faridnia.metime.getCurrentMonthName
import com.faridnia.metime.presentation.LightAndDarkPreview
import com.faridnia.metime.presentation.MeTimeTheme

@LightAndDarkPreview
@Composable
fun PreviewDaysInMonthComponent() {
    MeTimeTheme {
        DaysInMonthComponent(
            monthName = "October",
            availableDays = getSampleAvailableDays(),
            onMonthSelectedClick = {}
        )
    }
}

@Composable
fun DaysInMonthComponent(
    monthName: String,
    availableDays: List<AvailableDay>,
    onMonthSelectedClick: (String) -> Unit
) {

    val onMonthVisible = remember {
        mutableStateOf(false)
    }

    val selectedMonth = remember {
        mutableStateOf(getCurrentMonthName())
    }

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row {
            Text(
                text = "Day", style = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.raleway_light)),
                    fontWeight = FontWeight(600),
                    color = MaterialTheme.colorScheme.onSurface,
                    textAlign = TextAlign.Center,
                )
            )

            Spacer(modifier = Modifier.weight(1.0f))

            Text(
                modifier = Modifier.clickable {
                    onMonthSelectedClick(monthName)
                    onMonthVisible.value = onMonthVisible.value.not()
                },
                text = monthName,
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

        if (onMonthVisible.value) {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(items = getMonths(), key = { it.number }) { monthsNamesTriple ->
                    DateItem(
                        itemState = getItemState(selectedMonth.value, monthsNamesTriple.shortName),
                        dateString = monthsNamesTriple.shortName,
                        onItemSelectedClick = {
                            selectedMonth.value = it
                        })
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(items = availableDays, key = { it.id }) {
                DateItem(
                    dateString = formatDateToDayAndDayOfWeekInTwoLines(it.date),
                    onItemSelectedClick = {})
            }
        }
    }
}

fun getItemState(selectedMonth: String, monthName: String): DateItemState {
    return if (selectedMonth == monthName) {
        DateItemState.Selected
    } else {
        DateItemState.Default
    }
}

fun getMonths(): List<Month> {
    return listOf(
        Month(1, "January", "Jan"),
        Month(2, "February", "Feb"),
        Month(3, "March", "Mar"),
        Month(4, "April", "Apr"),
        Month(5, "May", "May"),
        Month(6, "June", "Jun"),
        Month(7, "July", "Jul"),
        Month(8, "August", "Aug"),
        Month(9, "September", "Sep"),
        Month(10, "October", "Oct"),
        Month(11, "November", "Nov"),
        Month(12, "December", "Dec"),
    )
}

data class Month(
    val number: Int,
    val fullName: String,
    val shortName: String,
    val isEnabled: Boolean = true,
    val isSelected: Boolean = false
)