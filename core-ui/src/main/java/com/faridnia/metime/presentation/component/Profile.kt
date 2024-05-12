package com.faridnia.metime.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.faridnia.metime.presentation.LightAndDarkPreview
import com.faridnia.metime.presentation.MeTimeTheme

@Composable
@LightAndDarkPreview
fun previewProfileComponent() {
    MeTimeTheme {
        ProfileComponent(name = "Anna Smith")
    }
}


@Composable
fun ProfileComponent(name: String) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.background)
            .padding(start = 24.dp, end = 24.dp),
    ) {


        Image(
            modifier = Modifier
                .width(98.dp)
                .height(98.dp)
                .clip(
                    shape = RoundedCornerShape(size = 10.dp)
                )
            ,
            painter = painterResource(id = R.drawable.pro_cal),
            contentDescription = "image description",
            contentScale = ContentScale.FillBounds
        )

        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = name,
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
}
