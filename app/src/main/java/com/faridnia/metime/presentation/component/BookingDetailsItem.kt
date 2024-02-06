package com.faridnia.metime.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Divider
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
import com.faridnia.metime.R
import com.faridnia.metime.presentation.ui.successful_booking.SuccessfulBookingData
import com.faridnia.metime.presentation.ui.successful_booking.getSampleSuccessfulBookingData
import com.faridnia.metime.presentation.LightAndDarkPreview
import com.faridnia.metime.util.formatTimeToDayInWeek

@LightAndDarkPreview
@Composable
fun PreviewBookingDetailsItem() {
    BookingDetailsItem(getSampleSuccessfulBookingData().first())
}

@Composable
fun BookingDetailsItem(successfulBookingData: SuccessfulBookingData) {
    Column {

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = successfulBookingData.salonName,
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 22.5.sp,
                fontFamily = FontFamily(Font(R.font.raleway_light)),
                fontWeight = FontWeight(700),
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center
            )
        )

        Row {
            Text(
                text = "with ${successfulBookingData.professionalData.name}",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.raleway_light)),
                    fontWeight = FontWeight(500),
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    letterSpacing = 0.1.sp
                )
            )
            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "5.0 Kms", // TODO Must update distance calculation
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.raleway_light)),
                    fontWeight = FontWeight(500),
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    letterSpacing = 0.1.sp
                )
            )
        }

        Text(
            text = successfulBookingData.serviceTypeList.map { it.title }.toString(),
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.raleway_light)),
                fontWeight = FontWeight(500),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                letterSpacing = 0.1.sp,
            )
        )

        Row {

            Text(
                text = formatTimeToDayInWeek(successfulBookingData.bookDate),
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.raleway_light)),
                    fontWeight = FontWeight(600),
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    letterSpacing = 0.15.sp,
                )
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "$" + successfulBookingData.price.toString(),
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.raleway_light)),
                    fontWeight = FontWeight(600),
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    letterSpacing = 0.15.sp,
                )
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Cancel",
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.raleway_light)),
                fontWeight = FontWeight(700),
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center,
            )
        )

    }

    Spacer(modifier = Modifier.height(16.dp))
    Divider(
        color = MaterialTheme.colorScheme.onSurfaceVariant
    )
}