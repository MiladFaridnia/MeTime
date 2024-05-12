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
            isMothVisible = true,
            availableDays = getSampleAvailableDays(),
            onMonthSelectedClick = {}
        )
    }
}

@Composable
fun DaysInMonthComponent(
    monthName: String,
    isMothVisible: Boolean = false,
    availableDays: List<AvailableDay>,
    onMonthSelectedClick: (String) -> Unit
) {

    val onMonthVisible = remember {
        mutableStateOf(isMothVisible)
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

        Spacer(modifier = Modifier.height(5.dp))

        if (onMonthVisible.value) {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(items = getMonths(), key = { it.number }) { month ->
                    DateItem(
                        itemState = getItemState(selectedMonth.value, month),
                        dateString = month.shortName,
                        onItemSelectedClick = {
                            selectedMonth.value = it
                        })
                }
            }
        }

        Spacer(modifier = Modifier.height(5.dp))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(items = availableDays, key = { it.id }) {
                DateItem(
                    dateString = formatDateToDayAndDayOfWeekInTwoLines(it.date),
                    onItemSelectedClick = {})
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

    }
}

fun getItemState(selectedMonth: String, month: Month): DateItemState {
    return if (month.isEnabled.not()) {
        DateItemState.DeActive
    } else if (selectedMonth == month.shortName) {
        DateItemState.Selected
    } else {
        DateItemState.Default
    }
}

fun getMonths(): List<Month> {
    return listOf(
        Month(1, "January", "Jan", isEnabled = false),
        Month(2, "February", "Feb"),
        Month(3, "March", "Mar"),
        Month(4, "April", "Apr", isEnabled = false),
        Month(5, "May", "May", isEnabled = false),
        Month(6, "June", "Jun"),
        Month(7, "July", "Jul"),
        Month(8, "August", "Aug"),
        Month(9, "September", "Sep"),
        Month(10, "October", "Oct"),
        Month(11, "November", "Nov"),
        Month(12, "December", "Dec")
    )
}

data class Month(
    val number: Int,
    val fullName: String,
    val shortName: String,
    val isEnabled: Boolean = true,
    val isSelected: Boolean = false
)