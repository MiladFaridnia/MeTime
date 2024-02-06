package com.faridnia.metime.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.faridnia.metime.presentation.LightAndDarkPreview
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.faridnia.metime.R

@LightAndDarkPreview
@Composable
fun PreviewBookingDetails(){
    BookingDetails()
}

@Composable
fun BookingDetails() {
    Column {

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
}