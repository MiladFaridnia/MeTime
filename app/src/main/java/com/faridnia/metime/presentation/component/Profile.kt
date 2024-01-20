package com.faridnia.metime.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
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
import com.faridnia.metime.R
import com.faridnia.metime.presentation.ui.professionals_calendar.ProsCalState


@Composable
fun ProfileComponent(state: State<ProsCalState>) {
    Image(
        modifier = Modifier
            .width(98.dp)
            .height(98.dp),
        painter = painterResource(id = R.drawable.pro_cal),
        contentDescription = "image description",
        contentScale = ContentScale.FillBounds
    )

    Text(
        text = state.value.professionalData.name, style = TextStyle(
            fontSize = 24.sp,
            fontFamily = FontFamily(Font(R.font.raleway_light)),
            fontWeight = FontWeight(600),
            color = MaterialTheme.colorScheme.onSurface,
            textAlign = TextAlign.Center,
        )
    )

    Spacer(modifier = Modifier.height(5.dp))

    Text(
        text = "Nail Designer", style = TextStyle(
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
            text = "5.0", style = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.raleway_light)),
                fontWeight = FontWeight(500),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center,
            )
        )
    }
}
