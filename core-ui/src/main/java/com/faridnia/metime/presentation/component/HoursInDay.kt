package com.faridnia.metime.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.faridnia.core.R
import com.faridnia.metime.core.data.model.AvailableHour
import com.faridnia.metime.core.data.model.getSampleAvailableHours
import com.faridnia.metime.formatTimeToHourInDay
import com.faridnia.metime.presentation.LightAndDarkPreview
import com.faridnia.metime.presentation.MeTimeTheme


@Composable
@LightAndDarkPreview
fun previewHourInDayComponent(){
    MeTimeTheme {
        HoursInDayComponent(availableHours = getSampleAvailableHours())
    }
}

@Composable
fun HoursInDayComponent(availableHours: List<AvailableHour>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(170.dp),
    ) {
        Text(
            text = "Availability",
            style = TextStyle(
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.raleway_light)),
                fontWeight = FontWeight(600),
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center,
            )
        )

        Spacer(modifier = Modifier.height(5.dp))

        LazyVerticalGrid(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            columns = GridCells.Fixed(2)
        ) {
            items(items = availableHours, key = { it.id }) {
                DateItem(
                    dateString = formatTimeToHourInDay(it.date),
                    onItemSelectedClick = {})
            }
        }

    }
}
